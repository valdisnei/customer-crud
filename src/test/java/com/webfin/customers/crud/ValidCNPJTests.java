package com.webfin.customers.crud;

import com.webfin.customers.model.Customer;
import com.webfin.customers.model.DocumentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.webfin.customers.validation.impl.ValidaCNPJ.isCNPJ;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class ValidCNPJTests {

    @Parameterized.Parameters(name = "input:{0} - output:{1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Customer(randomUUID().toString(), "jose's Consulting Ltda", "05871442000127", DocumentType.CNPJ), true},
                {new Customer(randomUUID().toString(),"maria's Consulting Ltda", "96964502000101",DocumentType.CNPJ), true},
                {new Customer(randomUUID().toString(),"joao's Consulting Ltda", "99514215029",DocumentType.CNPJ), false},
        });
    }

    private final Customer input;
    private final boolean expected;


    public ValidCNPJTests(Customer input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void to_valid_document() {
        assertEquals(expected, isCNPJ(input.getDocument()));
    }



}
