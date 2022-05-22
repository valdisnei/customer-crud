package com.webfin.crud;

import com.webfin.model.DocumentType;
import com.webfin.model.Customer;
import com.webfin.utils.impl.Validation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.function.Function;

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

		Assert.isTrue(!validation.apply(people));
	}



}
