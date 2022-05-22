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
public class ValidCPFTests {
    @Parameterized.Parameters(name = "input:{0} - output:{1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Validation(),new Customer(randomUUID().toString(),"jose","99515215099", DocumentType.CPF), true},
                {new Validation(),new Customer(randomUUID().toString(),"maria", "05001650500",DocumentType.CPF), true},
                {new Validation(),new Customer(randomUUID().toString(),"joao", "99514215029",DocumentType.CPF), false},
//                {new People(randomUUID().toString(),"Manuela", "05301650500",TipoDocumento.CPF)), false},
//                {new People(randomUUID().toString(),"Paula", new Documento("05301",TipoDocumento.CPF)), false},
//                {new People(randomUUID().toString(),"joaquim", new Documento("005001650500",TipoDocumento.CPF)), false},
//                {new People(randomUUID().toString(),"joaquim", new Documento(null,TipoDocumento.CPF)), false},
//                {new People(randomUUID().toString(),"joaquim", new Documento("",TipoDocumento.CPF)), false},
        });
    }

    private final Customer input;
    private final boolean expected;

    private final Function<Customer,Boolean> validation;

    public ValidCPFTests(Function<Customer, Boolean> validation, Customer input, boolean expected) {
        this.input = input;
        this.expected = expected;
        this.validation = validation;
    }

    @Test
    public void to_valid_document() {
        assertEquals(expected, validation.apply(input));
    }

}
