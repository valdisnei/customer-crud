package com.webfin.crud;

import com.webfin.model.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.webfin.utils.ValidaCPF.isCPF;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class ValidCPFTests {
    @Parameterized.Parameters(name = "input:{0} - output:{1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new People(randomUUID().toString(),"jose", "99515215099"), true},
                {new People(randomUUID().toString(),"maria", "05001650500"), true},
                {new People(randomUUID().toString(),"joao", "99514215029"), false},
                {new People(randomUUID().toString(),"Manuela", "05301650500"), false},
                {new People(randomUUID().toString(),"Paula", "05301"), false},
                {new People(randomUUID().toString(),"joaquim", "005001650500"), false},

        });
    }

    private final People input;
    private final boolean expected;

    public ValidCPFTests(People input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void to_valid_document() {
        assertEquals(expected, isCPF(input.getDocument()));
    }

}
