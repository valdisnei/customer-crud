package com.webfin.customers.api;

import com.webfin.customers.model.Customer;
import com.webfin.customers.pagination.ResponseDto;
import com.webfin.customers.services.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@Slf4j
@AllArgsConstructor
@RestController
public class CustomerOpenApiImpl implements CustomerOpenApi {
    private final CustomerServiceImpl contatoService;

    @Override
    public ResponseDto<Customer> getCustomers(Integer page, Integer linesPerPage) {
        var body = contatoService.allCustomers(page, linesPerPage);
        return body;
    }

    public ResponseEntity create(Customer customer) {
        contatoService.create(customer);
        return ResponseEntity.status(CREATED).build();
    }

    @Override
    public ResponseEntity<Customer> update(String id, Customer customer) {
        Customer updateCustomer = contatoService.update(id, customer);
        return ResponseEntity.status(ACCEPTED).body(updateCustomer);
    }

    @Override
    public ResponseEntity delete(String id) {
         contatoService.delete(id);
         return ResponseEntity.status(NO_CONTENT).build();
    }

}

