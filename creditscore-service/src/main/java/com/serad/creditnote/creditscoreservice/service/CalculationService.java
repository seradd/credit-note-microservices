package com.serad.creditnote.creditscoreservice.service;

import com.serad.creditnote.creditscoreservice.models.Customer;
import org.springframework.stereotype.Component;

@Component
public interface CalculationService {

    public Double calculateCreditNote(Customer customer);

}
