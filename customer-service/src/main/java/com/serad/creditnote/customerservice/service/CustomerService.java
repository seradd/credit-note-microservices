package com.serad.creditnote.customerservice.service;

import com.serad.creditnote.customerservice.models.CreditResult;
import com.serad.creditnote.customerservice.models.Customer;
import org.springframework.stereotype.Component;

@Component
public interface CustomerService {

    CreditResult calculateCreditNote(Customer customer);
}
