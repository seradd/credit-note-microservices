package com.serad.creditnote.notificationservice.service;

import com.serad.creditnote.notificationservice.model.SmsReq;
import com.twilio.rest.api.v2010.account.Message;

public interface SmsService {

    Message sendSMS(SmsReq smsReq);
}
