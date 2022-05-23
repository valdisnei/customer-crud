package com.webfin.customers.validation.impl;

import com.webfin.customers.model.Customer;
import com.webfin.customers.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
public class Validation implements Function<Customer, Boolean> {

    @Override
    public Boolean apply(Customer customer) {
         Optional.of(customer.getDocumentType().isValid(customer.getDocument()))
                .filter(res -> !res)
                .map(res -> {
                    throw new BadRequestException(
                            String.format("%s invalid!",customer)
                    );
                })
                .isPresent();

         return true;
    }
}
