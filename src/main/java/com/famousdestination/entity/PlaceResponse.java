package com.famousdestination.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlaceResponse {
	
	private int id;
	
	private String placeName;
	
	private String placelocation;
	
	private String placeDescription;
	
	private String placeRatings;
	
	private String placeImgUrl; 
	
	private String country; 
	
}
