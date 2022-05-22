package com.webfin.api;

import com.webfin.model.Customer;
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

    @PostMapping("/create")
    private ResponseEntity<String> save(@RequestBody @Valid Customer customer) {

        log.info("Customer: {} - Document: {}", customer, validation.apply(customer));
        return ResponseEntity.ok("");
    }
}
