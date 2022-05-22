package com.webfin.api;

import com.webfin.model.Customer;
import com.webfin.pagination.ResponseDto;
import com.webfin.repository.CustomerRepository;
import com.webfin.services.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@AllArgsConstructor
@RestController
public class CustomerOpenApiImpl implements CustomerOpenApi {

    private final Function<Customer, Boolean> validation;
    private final CustomerRepository customerRepository;
    private final CustomerServiceImpl contatoService;

    @Override
    public ResponseDto<Customer> getCustomers(Integer page, Integer linesPerPage) {
        var body = contatoService.allCustomers(page, linesPerPage);
        return body;
    }

    public ResponseEntity<Customer> create(Customer customer) {
        log.info("Customer: {} - Document: {}", customer, validation.apply(customer));
        Customer dbCustomer = customerRepository.save(customer);
        return ResponseEntity.status(CREATED).body(dbCustomer);
    }
}

