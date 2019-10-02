package com.serad.creditnote.creditscoreservice.service.impl;

import com.serad.creditnote.creditscoreservice.models.Customer;
import com.serad.creditnote.creditscoreservice.repository.CreditScoreRepository;
import com.serad.creditnote.creditscoreservice.service.CalculationService;
import com.serad.creditnote.creditscoreservice.service.CreditScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditScoreServiceImpl implements CreditScoreService {

    private final Logger LOG = LoggerFactory.getLogger(CreditScoreServiceImpl.class);

    @Autowired
    CreditScoreRepository creditScoreRepository;

    @Autowired
    CalculationService calculationService;

    @Override
    public Double getCustomerCreditScore(String tckn) {
        try {
            Customer customer = creditScoreRepository.findByTcknEquals(tckn);
            return calculateCustomerScore(customer);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Customer> createCustomer(List<Customer> customer) {
        return customer.stream()
                .map(c -> {
                    return creditScoreRepository.save(c);
                }).collect(Collectors.toList());
    }

    private Double calculateCustomerScore(Customer customer) {

        return calculationService.calculateCreditNote(customer);
    }

}
