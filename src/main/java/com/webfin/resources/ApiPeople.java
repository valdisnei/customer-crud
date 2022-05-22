package com.webfin.resources;

import com.webfin.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class ApiPeople {


    @PostMapping("/create")
    private ResponseEntity<String> save(@RequestBody @Valid Customer customer){
        return ResponseEntity.ok("");
    }
}
