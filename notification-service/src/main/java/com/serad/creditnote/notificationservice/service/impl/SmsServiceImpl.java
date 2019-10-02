package com.serad.creditnote.notificationservice.service.impl;

import com.serad.creditnote.notificationservice.model.SmsReq;
import com.serad.creditnote.notificationservice.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private Environment env;

    private final Logger LOG = LoggerFactory.getLogger(SmsServiceImpl.class);

    public static final String  APPROVED_MESSAGE = " kredi başvurunuz onaylanmış olup kredi limitiniz ";
    public static final String  APPROVED_MESSAGE2 = " TL dir";
    public static final String  REJECTED_MESSAGE = " kredi başvurunuz onaylanmıştır.";
    public static final String  SAYIN = "Sayın ";


    public static final String ACCOUNT_SID = "XXXXXXXXXXXXXXXXXXXX";
    public static final String AUTH_TOKEN = "XXXXXXXXXXXXXXXXXXXX";


    @Override
    public Message sendSMS(SmsReq smsReq) {

        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber(smsReq.getPhoneNumber()),
                    new com.twilio.type.PhoneNumber("+XXXXXXXXXXX"),
                    SAYIN + smsReq.getFullName() + (smsReq.getApprovalStatus()?APPROVED_MESSAGE:REJECTED_MESSAGE + smsReq.getLimitInfo() + APPROVED_MESSAGE2))
                    .create();

            return message;
        }catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return null;
    }
}
