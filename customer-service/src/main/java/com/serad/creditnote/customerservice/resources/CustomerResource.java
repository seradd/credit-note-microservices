package com.serad.creditnote.customerservice.resources;

import com.serad.creditnote.customerservice.models.CreditResult;
import com.serad.creditnote.customerservice.models.Customer;
import com.serad.creditnote.customerservice.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("api/customer")
public class CustomerResource {

    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    CustomerService customerService;

    private final Logger LOG = LoggerFactory.getLogger(CustomerResource.class);

    @PostMapping(value = "/credit-note-result")
    public ResponseEntity<CreditResult> getCustomerCreditNoteResult(@RequestBody Customer customer) {

        return new ResponseEntity<>(customerService.calculateCreditNote(customer), HttpStatus.OK);
    }

}
