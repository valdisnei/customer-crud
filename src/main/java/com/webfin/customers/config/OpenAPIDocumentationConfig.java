package com.webfin.customers.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class OpenAPIDocumentationConfig {

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Api Customer Documentation")
				.description("Criação de API para gestão de contatos da WebFin.")
				.termsOfServiceUrl("").version("1.0.0")
				.contact(new Contact("webfin", "https://webfin.com/", null))
				.build();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.build()
				.directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false);
	}

}
