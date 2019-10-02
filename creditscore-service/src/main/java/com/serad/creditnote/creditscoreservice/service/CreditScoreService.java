package com.serad.creditnote.creditscoreservice.service;

import com.serad.creditnote.creditscoreservice.models.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CreditScoreService {

    Double getCustomerCreditScore(String tckn);
    List<Customer> createCustomer(List<Customer> customer);
}
