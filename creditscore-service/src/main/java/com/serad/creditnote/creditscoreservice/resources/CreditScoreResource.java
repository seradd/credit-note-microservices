package com.serad.creditnote.creditscoreservice.resources;

import com.serad.creditnote.creditscoreservice.models.Customer;
import com.serad.creditnote.creditscoreservice.service.CreditScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/creditscore")
public class CreditScoreResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private CreditScoreService creditScoreService;

    @GetMapping(value = "/score-result/{tckn}")
    public ResponseEntity<Double> getCustomerCreditScore(@PathVariable(value = "tckn") String tckn) {
        return new ResponseEntity<>(creditScoreService.getCustomerCreditScore(tckn), HttpStatus.OK);
    }

    @PostMapping(value = "create-customer")
    public ResponseEntity<List<Customer>> createUser(@RequestBody List<Customer> customer) {
        return new ResponseEntity<>(creditScoreService.createCustomer(customer), HttpStatus.OK);
    }

}
