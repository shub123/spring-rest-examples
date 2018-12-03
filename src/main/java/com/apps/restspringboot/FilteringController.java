package com.apps.restspringboot;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue retrieveBean() {
		SomeBean b = new SomeBean("v1" , "v2" , "v3");
		
		SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("a","b");
		FilterProvider filters =  new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue map = new MappingJacksonValue(b);
		
		map.setFilters(filters);
		
		
		return map;
		
		
	}
}
