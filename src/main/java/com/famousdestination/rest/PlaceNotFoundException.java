package com.famousdestination.rest;

public class PlaceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlaceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlaceNotFoundException(String message) {
		super(message);
	}

	public PlaceNotFoundException(Throwable cause) { 
		super(cause); 
	}
	
	
	
}
