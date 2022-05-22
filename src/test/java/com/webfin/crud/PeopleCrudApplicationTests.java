package com.webfin.crud;

import com.webfin.model.People;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@Slf4j
@SpringBootTest
class PeopleCrudApplicationTests {

	@Test
	void has_cpf() {
		People people = new People();
		people.setDocument("2112312313");
		people.setName("Jose");

		Assert.isTrue(Strings.isNotBlank(people.getDocument()));
	}

}
