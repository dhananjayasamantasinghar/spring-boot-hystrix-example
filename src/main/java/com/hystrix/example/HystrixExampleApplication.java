package com.hystrix.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixExampleApplication.class, args);
//			Controller URL: http://localhost:8092/rest/all
//			Hystrix Dashboard URL: http://localhost:8092/hystrix
//			Hystrix Stream URL: http://localhost:8092/actuator/hystrix.stream

	}
}
