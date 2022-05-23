package com.webfin.customers.crud;

import com.webfin.customers.model.Customer;
import com.webfin.customers.model.DocumentType;
import com.webfin.customers.validation.impl.Validation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.function.Function;

import static com.webfin.customers.validation.impl.ValidaCPF.isCPF;

@Slf4j
@SpringBootTest
class CustomerCrudApplicationTests {


	@Test
	void has_cpf() {
		Function<Customer,Boolean> validation = new Validation();
		Customer people = new Customer();
		people.setDocument("2112312313");
		people.setDocumentType(DocumentType.CPF);
		people.setName("Jose");

		Assert.isTrue(!isCPF(people.getDocument()));
	}



}
