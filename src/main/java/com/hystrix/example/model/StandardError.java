package com.hystrix.example.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StandardError {

	private String message;
	private String time;
	private String errorCode;
	
	
	public StandardError() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getTime() {
		LocalDateTime current = LocalDateTime.now(); 
		DateTimeFormatter format =  
			      DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		this.time = current.format(format);
		return time;
	}
	
}
