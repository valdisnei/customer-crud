package com.webfin.api;

import com.webfin.model.Customer;
import com.webfin.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.function.Function;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class ApiCustomer {

    private final Function<Customer, Boolean> validation;

    private final CustomerRepository customerRepository;

    @PostMapping("/create")
    private ResponseEntity<Customer> save(@RequestBody @Valid Customer customer) {

        log.info("Customer: {} - Document: {}", customer, validation.apply(customer));

        Customer dbCustomer = customerRepository.save(customer);

        return ResponseEntity.ok(dbCustomer);
    }
}
