package com.serad.creditnote.customerservice.repository;

import com.serad.creditnote.customerservice.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {


}