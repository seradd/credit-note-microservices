package com.serad.creditnote.creditscoreservice.service.impl;

import com.serad.creditnote.creditscoreservice.models.Customer;
import com.serad.creditnote.creditscoreservice.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CalculationServiceImpl implements CalculationService {

    @Autowired
    private Environment env;

    @Override
    public Double calculateCreditNote(Customer customer) {

        Double defaultMultiplier = env.getProperty("credit.default.limit.multiplier", Double.class, 4.00);
        Double minScoreTreshold = env.getProperty("credit.min.score.treshold", Double.class, 500.00);
        Double maxScoreTreshold = env.getProperty("credit.max.score.treshold", Double.class, 1000.00);
        Double monthlyIncomeTreshold = env.getProperty("credit.monthlyincome.treshold", Double.class, 5000.00);
        Double customerBetweenTreshold = env.getProperty("credit.betweentreshold.value", Double.class, 10000.00);

        Double creditScore = customer.getCreditScore();

        if (creditScore.compareTo(minScoreTreshold) > 0 && creditScore.compareTo(maxScoreTreshold) < 1
        && customer.getMonthlyIncome().compareTo(monthlyIncomeTreshold) < 0) {
            return customerBetweenTreshold;
        } else if (creditScore.compareTo(maxScoreTreshold) >= 0) {
            return creditScore * defaultMultiplier;
        } else {
            return 0d;
        }
    }
}
