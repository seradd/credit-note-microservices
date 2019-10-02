package com.serad.creditnote.creditscoreservice.repository;

import com.serad.creditnote.creditscoreservice.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditScoreRepository extends MongoRepository<Customer, String> {

    Customer findByTcknEquals(String tckn);

}