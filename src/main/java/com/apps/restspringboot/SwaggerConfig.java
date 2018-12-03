package com.apps.restspringboot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Sak", "http://app.com", "app@gmail.com");
	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("MY APP API DOCS", "Amazing API  Documentation", "1.0",
			"urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	private static final Set<String> DEFAULT_PROC_AND_CONS = new HashSet<String>(Arrays.asList("application/xml", "application/json"));

	// /v2/api-docs - json format api spec
	//
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(DEFAULT_PROC_AND_CONS)
				.consumes(DEFAULT_PROC_AND_CONS);
	}
}
