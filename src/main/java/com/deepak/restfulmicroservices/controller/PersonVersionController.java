package com.deepak.restfulmicroservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.restfulmicroservices.bean.Name;
import com.deepak.restfulmicroservices.bean.PersonV1;
import com.deepak.restfulmicroservices.bean.PersonV2;

@RestController
public class PersonVersionController {

	@GetMapping(value = "v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Deepak Mandal");
	}
	
	@GetMapping(value = "v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Deepak", "Mandal"));
	}
	
	@GetMapping(value = "person/params", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Deepak Mandal");
	}
	
	@GetMapping(value = "person/params", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Deepak", "Mandal"));
	}
	
	@GetMapping(value = "person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Deepak Mandal");
	}
	
	@GetMapping(value = "person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Deepak", "Mandal"));
	}
	
	@GetMapping(value = "person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Deepak Mandal");
	}
	
	@GetMapping(value = "person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Deepak", "Mandal"));
	}
}
