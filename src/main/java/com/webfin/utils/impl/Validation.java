package com.webfin.utils.impl;

import com.webfin.model.Customer;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class Validation implements Function<Customer,Boolean> {

    @Override
    public Boolean apply(Customer customer) {
        return customer.getDocumentType().isValid(customer.getDocument());
    }
}
