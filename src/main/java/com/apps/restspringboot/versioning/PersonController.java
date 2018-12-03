package com.apps.restspringboot.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@GetMapping("/v1/person")
	public PersonV1 personv1() {
		return new PersonV1("Jack");
	}

	@GetMapping("/v2/person")
	public PersonV2 personv2() {
		return new PersonV2("James", "Andrew");
	}

	@GetMapping(value = "/person", params = "version=1")
	public PersonV1 personv1param() {
		return new PersonV1("Jack");
	}

	@GetMapping(value = "/person", params = "version=2")
	public PersonV2 personv2param() {
		return new PersonV2("James", "Andrew");
	}

	@GetMapping(value = "/person", headers = "X-API-VERSION=1")
	public PersonV1 personv1header() {
		return new PersonV1("Jack");
	}

	@GetMapping(value = "/person", headers = "X-API-VERSION=2")
	public PersonV2 personv2header() {
		return new PersonV2("James", "Andrew");
	}

	@GetMapping(value = "/person", produces = "application/app-v1+json")
	public PersonV1 personv1hproduces() {
		return new PersonV1("Jack");
	}

	@GetMapping(value = "/person", produces = "application/app-v2+json")
	public PersonV2 personv2hproduces() {
		return new PersonV2("James", "Andrew");
	}

}
