package com.hackerrank.api.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
@ResponseStatus
public class GlobalException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = ElementNotFoundException.class)
	public ResponseEntity<Object> handleElementNotFoundException(ElementNotFoundException ex,WebRequest request){
		String message = ex.getMessage();
		if(message == null) message=ex.toString();
		 ApiException vr =  new ApiException(true, "Element Not found Exception");
		
		return new  ResponseEntity<>(vr,new HttpHeaders(),HttpStatus.NOT_FOUND);
		
	}
	
	
	
	

	
}
