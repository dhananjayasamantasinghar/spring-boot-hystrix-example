package com.hystrix.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hystrix.example.model.StandardError;
import com.hystrix.example.service.RestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/rest")
public class RestResource {
	
	@Autowired
	private RestService service;


    @HystrixCommand(fallbackMethod = "countryFallBack",
            commandKey = "country-service")
    @GetMapping(value = "/all", produces={MediaType.APPLICATION_JSON_UTF8_VALUE} )
    public ResponseEntity<String> getAllCountries() {
        
        return ResponseEntity
        		.ok()
        		.body(service.getCountries());
    }

    public ResponseEntity<String> countryFallBack() throws Exception {
    	StandardError error = new StandardError();
    	error.setErrorCode("CS-500");
    	error.setMessage("Country Service is taking more time to response, Please try after some time ");
    	
    	 return ResponseEntity
         		.status(HttpStatus.INTERNAL_SERVER_ERROR)
         		.body(new ObjectMapper().writeValueAsString(error));
    }
}
