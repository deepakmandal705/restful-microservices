package com.deepak.restfulmicroservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.restfulmicroservices.bean.MessageBean;

@RestController
public class HelloWorldController {
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@GetMapping(value = "hello-world-internationalized")
	public String helloWorldInternationalizedHeader(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	
	@GetMapping(value = "hello-world-internationalized2")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}

	@GetMapping(value = "hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(value = "message-bean")
	public MessageBean message() {
		return new MessageBean("Welcome To Spring Boot");
	}
	
	@GetMapping(value = "hello/{name}")
	public String helloPathVariable(@PathVariable String name) {
		return "Hello, "+name;
	}
}
