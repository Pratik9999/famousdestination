package com.famousdestination.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlaceErrorResponse {
	
	private int status;
	
	private String message;
	
	private Long timestamp; 
	
}

















