package com.webfin.crud;

import com.webfin.model.Customer;
import com.webfin.model.DocumentType;
import com.webfin.utils.impl.Validation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class ValidCNPJTests {

    @Parameterized.Parameters(name = "input:{0} - output:{1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Validation(),new Customer(randomUUID().toString(), "jose's Consulting Ltda", "05871442000127", DocumentType.CNPJ), true},
                {new Validation(),new Customer(randomUUID().toString(),"maria's Consulting Ltda", "96964502000101",DocumentType.CNPJ), true},
                {new Validation(),new Customer(randomUUID().toString(),"joao's Consulting Ltda", "99514215029",DocumentType.CNPJ), false},
//                {new People(randomUUID().toString(),"Manuela 's Consulting Ltda", neww Documento("05301650500",TipoDocumento.CNPJ)), false},
//                {new People(randomUUID().toString(),"Paula's Consulting Ltda", new Documento("05301",TipoDocumento.CNPJ)), false},
//                {new People(randomUUID().toString(),"joaquim's Consulting Ltda", new Documento("005001650500",TipoDocumento.CNPJ)), false},
//                {new People(randomUUID().toString(),"joaquim's Consulting Ltda", new Documento(null,TipoDocumento.CNPJ)), false},
//                {new People(randomUUID().toString(),"joaquim's Consulting Ltda", new Documento("",TipoDocumento.CNPJ)), false},

        });
    }

    private final Function<Customer,Boolean> validation;
    private final Customer input;
    private final boolean expected;


    public ValidCNPJTests(Function<Customer, Boolean> validation, Customer input, boolean expected) {
        this.validation = validation;
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void to_valid_document() {
        assertEquals(expected, validation.apply(input));
    }



}
