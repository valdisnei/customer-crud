package com.webfin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    private String id;
    @NotBlank
    private String name;
    private String document;
    private DocumentType documentType;

}
