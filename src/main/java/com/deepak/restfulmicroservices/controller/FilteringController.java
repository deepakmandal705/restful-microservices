package com.deepak.restfulmicroservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.restfulmicroservices.bean.FilteringBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping(value = "filter")
	public FilteringBean getFilter() {
		FilteringBean filteringBean = new FilteringBean("Deepak", "Cos", "123", "1234");
		return filteringBean;
	}
	
	@GetMapping(value = "filter-list")
	public List<FilteringBean> getFilterList() {
		List<FilteringBean> filteringList = Arrays.asList(new FilteringBean("Deepak", "Cos", "123", "1234"),
				new FilteringBean("Deepak2", "Cos2", "456", "1235"));
		return filteringList;
	}
	
	@GetMapping(value = "dynamic/filter")
	public MappingJacksonValue getDynamicFilter() {
		FilteringBean filteringBean = new FilteringBean("Deepak", "Cos", "123", "1234");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("userName","organization","password");
		
		FilterProvider provider = new SimpleFilterProvider().addFilter("SampleBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(filteringBean);
		mapping.setFilters(provider);
		return mapping;
	}
	
	@GetMapping(value = "dynamic/filter-list")
	public MappingJacksonValue getDynamicFilterList() {
		List<FilteringBean> filteringList = Arrays.asList(new FilteringBean("Deepak", "Cos", "123", "1234"),
				new FilteringBean("Deepak2", "Cos2", "456", "1235"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("userName","organization");
		
		FilterProvider provider = new SimpleFilterProvider().addFilter("SampleBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(filteringList);
		mapping.setFilters(provider);
		return mapping;
	}
}
