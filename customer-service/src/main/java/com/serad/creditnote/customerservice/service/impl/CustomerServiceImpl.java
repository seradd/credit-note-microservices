package com.serad.creditnote.customerservice.service.impl;

import com.serad.creditnote.customerservice.enumaration.ApprovalStatus;
import com.serad.creditnote.customerservice.models.CreditApplications;
import com.serad.creditnote.customerservice.models.CreditResult;
import com.serad.creditnote.customerservice.models.Customer;
import com.serad.creditnote.customerservice.models.SmsReq;
import com.serad.creditnote.customerservice.repository.CreditApplicationsRepository;
import com.serad.creditnote.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    CreditApplicationsRepository creditApplicationsRepository;

    @Override
    public CreditResult calculateCreditNote(Customer customer) {

        Double scoreResult = restTemplate.getForObject("http://creditscore-service/api/creditscore/score-result/" + customer.getTckn(), Double.class);
        CreditResult creditResult = new CreditResult();
        creditResult.setLimitInfo(scoreResult);
        creditResult.setApprovalStatus(scoreResult > 0 ? ApprovalStatus.APPROVED:ApprovalStatus.REJECTED);
        saveApplication(customer, creditResult);
        sendSms(customer, creditResult);
        return creditResult;
    }

    public void sendSms(Customer customer, CreditResult creditResult) {
        SmsReq smsReq = new SmsReq();
        smsReq.setFullName(customer.getName() + customer.getSurname());
        smsReq.setPhoneNumber(customer.getPhoneNumber());
        smsReq.setApprovalStatus(ApprovalStatus.APPROVED.equals(creditResult.getApprovalStatus())?Boolean.TRUE: Boolean.FALSE);
        smsReq.setLimitInfo(creditResult.getLimitInfo());

        restTemplate.postForObject("http://notification-service/api/notificationservice/send-sms/", smsReq, Message.class);
    }

    public void saveApplication(Customer customer, CreditResult creditResult) {
        CreditApplications creditApplication = new CreditApplications();
        creditApplication.setTckn(customer.getTckn());
        creditApplication.setApprovalStatus(creditResult.getApprovalStatus());
        creditApplication.setLimit(creditResult.getLimitInfo());
    }
}
