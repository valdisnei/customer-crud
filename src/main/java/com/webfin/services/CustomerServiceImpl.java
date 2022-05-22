package com.webfin.services;

import com.webfin.adapter.impl.AdapterPagination;
import com.webfin.exception.BadRequestException;
import com.webfin.exception.NotFoundException;
import com.webfin.pagination.ResponseDto;
import com.webfin.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class CustomerServiceImpl {

    private final CustomerRepository contatoRepository;
//    private final AdapterContatoDto adapterContatoDto;
    private final AdapterPagination adapterPagination;

//    public ContatoDto save(ContatoDto contatoDto) {
//        log.info("Inserting Contato: [{}] in mongoDB", contatoDto.getEmail());
//        var cast = adapterContatoDto.cast(contatoDto);
//        contatoRepository.save(cast.get());
//        return contatoDto;
//    }

    public ResponseDto allCustomers(int page, int size) {
        if (page <= 0 || size <= 0)
            throw new BadRequestException(
                    String.format("Page and LinesPerPage index must major than zero!")
            );

        if (size > 1000)
            throw new BadRequestException(
                    String.format("LinesPerPage cant be greater than 1000!")
            );


        Pageable paging = PageRequest.of(page - 1, size);
        var all = Optional.ofNullable(contatoRepository.findAll(paging))
                .orElseThrow(()->new NotFoundException("Customer not Found!"));

        var pageable = adapterPagination.cast(all);
        return pageable.get();
    }

}
