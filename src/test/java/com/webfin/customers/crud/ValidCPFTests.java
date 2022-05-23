package com.webfin.customers.crud;

import com.webfin.customers.model.Customer;
import com.webfin.customers.model.DocumentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.webfin.customers.validation.impl.ValidaCPF.isCPF;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class ValidCPFTests {
    @Parameterized.Parameters(name = "input:{0} - output:{1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Customer(randomUUID().toString(),"jose","99515215099", DocumentType.CPF), true},
                {new Customer(randomUUID().toString(),"maria", "05001650500",DocumentType.CPF), true},
                {new Customer(randomUUID().toString(),"joao", "99514215029",DocumentType.CPF), false},
        });
    }

    private final Customer input;
    private final boolean expected;

    public ValidCPFTests(Customer input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void to_valid_document() {
        assertEquals(expected, isCPF(input.getDocument()));
    }

}
