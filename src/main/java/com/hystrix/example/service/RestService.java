package com.hystrix.example.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

	private RestTemplate restTemplate;
	
	public RestService(RestTemplateBuilder builder){
		this.restTemplate = builder.build();
	}
	public String getCountries(){
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-rapidapi-host", "restcountries-v1.p.rapidapi.com");
		headers.add("x-rapidapi-key", "1cfbdceb89msh5ae0c25f8a27b7ap17353djsn03ed743b1d4f");
		
		HttpEntity<?> entity = new HttpEntity<>(headers);
		return restTemplate
				.exchange("https://restcountries-v1.p.rapidapi.com/all",
				HttpMethod.GET,
				entity, 
				String.class)
				.getBody();
		
	}
}
