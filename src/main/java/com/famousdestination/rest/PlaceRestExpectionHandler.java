package com.famousdestination.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlaceRestExpectionHandler {
	
	@ExceptionHandler
	ResponseEntity<PlaceErrorResponse> handleException(PlaceNotFoundException exc) {
		
		PlaceErrorResponse err = new PlaceErrorResponse();
		
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setMessage(exc.getMessage());
		err.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<PlaceErrorResponse>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	ResponseEntity<PlaceErrorResponse> handleException(Exception exc) {
		
		PlaceErrorResponse err = new PlaceErrorResponse();
		
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(exc.getMessage());
		err.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<PlaceErrorResponse>(err, HttpStatus.BAD_REQUEST);
	} 
	

	
	
	
	
}
