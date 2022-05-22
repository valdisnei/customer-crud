package com.webfin.adapter.impl;

import com.webfin.adapter.Adapter;
import com.webfin.model.Customer;
import com.webfin.pagination.ResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdapterPagination implements Adapter<Page<Customer>, ResponseDto<Customer>> {

    @Override
    public Optional<ResponseDto<Customer>> cast(Page<Customer> page) {

        var responseDto = ResponseDto.<Customer>builder()
                .content(page.getContent())
                .first(page.isFirst())
                .last(page.isLast())
                .pageNumber(page.getNumber() + 1)
                .numberOfElements(page.getNumberOfElements())
                .size(page.getSize())
                .totalElements(Long.valueOf(page.getTotalElements()).intValue())
                .totalPages(page.getTotalPages())
                .build();
        return Optional.of(responseDto);
    }
}
