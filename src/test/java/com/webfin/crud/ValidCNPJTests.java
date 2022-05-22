package com.webfin.crud;

import com.webfin.model.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.webfin.utils.ValidaCNPJ.isCNPJ;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class ValidCNPJTests {
    @Parameterized.Parameters(name = "input:{0} - output:{1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new People(randomUUID().toString(),"jose's Consulting Ltda", "05871442000127"), true},
                {new People(randomUUID().toString(),"maria's Consulting Ltda", "96964502000101"), true},
                {new People(randomUUID().toString(),"joao's Consulting Ltda", "99514215029"), false},
                {new People(randomUUID().toString(),"Manuela 's Consulting Ltda", "05301650500"), false},
                {new People(randomUUID().toString(),"Paula's Consulting Ltda", "05301"), false},
                {new People(randomUUID().toString(),"joaquim's Consulting Ltda", "005001650500"), false},

        });
    }

    private final People input;
    private final boolean expected;

    public ValidCNPJTests(People input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void to_valid_document() {
        assertEquals(expected, isCNPJ(input.getDocument()));
    }

}
