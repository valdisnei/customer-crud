package com.webfin.customers.services;

import com.webfin.customers.adapter.Adapter;
import com.webfin.customers.exception.NotFoundException;
import com.webfin.customers.model.Customer;
import com.webfin.customers.exception.BadRequestException;
import com.webfin.customers.pagination.ResponseDto;
import com.webfin.customers.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import static java.lang.String.format;

@Slf4j
@Component
@AllArgsConstructor
public class CustomerServiceImpl {
    private final Function<Customer, Boolean> validation;
    private final CustomerRepository customerRepository;
    private final Adapter<Page<Customer>, ResponseDto<Customer>> adapterPagination;

    public void create(Customer customer) {
        customerRepository.findByDocument(customer.getDocument())
                .ifPresent((doc) -> {
                    throw new BadRequestException(
                            format("Document (%S) [ %S ] already exist!", doc.getDocumentType(), doc.getDocument()));
                });

        Optional.of(customer)
                .filter(validation::apply)
                .filter(cus -> Objects.isNull(cus.getId()))
                .ifPresent(customerRepository::save);
    }
    public Customer update(String id, Customer customer) {
        customer.setId(id);
        customerRepository.findById(customer.getId())
                .orElseThrow(
                        () -> new BadRequestException(
                                format("ID [ %S ] Not Found!", customer.getId())
                        )
                );

        Optional.of(customer)
                .filter(validation::apply)
                .ifPresent(customerRepository::save);

        return customer;
    }

    public void delete(String id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new BadRequestException(
                format("ID [ %S ] Not Found!", id)
        ));
        customerRepository.delete(customer);
    }

    public ResponseDto allCustomers(int page, int size) {
        if (page <= 0 || size <= 0)
            throw new BadRequestException(
                    format("Page and LinesPerPage index must major than zero!")
            );

        if (size > 1000)
            throw new BadRequestException(
                    format("LinesPerPage cant be greater than 1000!")
            );


        Pageable paging = PageRequest.of(page - 1, size);
        var all = Optional.ofNullable(customerRepository.findAll(paging))
                .orElseThrow(() -> new NotFoundException("Customer not Found!"));

        var pageable = adapterPagination.cast(all);
        return pageable.get();
    }
}
