package com.serad.creditnote.notificationservice.resources;

import com.serad.creditnote.notificationservice.model.SmsReq;
import com.serad.creditnote.notificationservice.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.twilio.rest.api.v2010.account.Message;

@RestController
@RequestMapping("api/notificationservice")
public class NotificationResource {

    @Autowired
    SmsService smsService;


    @PostMapping(value = "/send-sms")
    public ResponseEntity<Message> getCustomerCreditNoteResult1(@RequestBody SmsReq smsReq) {

        return new ResponseEntity<>(smsService.sendSMS(smsReq), HttpStatus.OK);
    }

}
