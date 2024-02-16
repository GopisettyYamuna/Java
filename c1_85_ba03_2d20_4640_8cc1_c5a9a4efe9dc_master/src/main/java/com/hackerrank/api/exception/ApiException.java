package com.hackerrank.api.exception;

import java.util.Objects;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiException {
	
	/*private final String message;
	private final  HttpStatus httpStatus;
	
	public ApiException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}*/
	 private static final boolean FAILURE = false;
	private final boolean success;
	 private final String message;
	 
	 public ApiException(boolean success, String message) {
			super();
			this.success = success;
			this.message = message;
		}

		public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	static ApiException fail(String message) {
		 return new ApiException(FAILURE, message);
		 }

	
	


	 
	 
	
	

}
