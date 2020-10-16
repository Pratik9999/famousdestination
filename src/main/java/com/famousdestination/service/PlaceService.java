package com.famousdestination.service;

import java.util.List;

import com.famousdestination.entity.Place;
import com.famousdestination.entity.PlaceResponse;

public interface PlaceService {
	
	public List<PlaceResponse> getAllPlaces();
	
	public PlaceResponse getPlaceById(int theId);
	
	public String savePlace(Place thePlace);
	
	public String deletePlace(int theId);
	
	public List<PlaceResponse> getPlacesByCountryName(String name);
	
}
