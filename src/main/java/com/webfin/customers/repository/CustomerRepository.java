package com.webfin.customers.repository;

import com.webfin.customers.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    @Override
    Optional<Customer> findById(String id);

    Optional<Customer> findByDocument(String document);

}
