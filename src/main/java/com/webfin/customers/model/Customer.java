package com.webfin.customers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "customer")
public class Customer {

    @Id
    @JsonProperty("id")
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String document;
    @NonNull
    private DocumentType documentType;

}
