package com.famousdestination.service;

import java.util.List;

import com.famousdestination.entity.PlaceImage;

public interface PlaceImageService {
	
	public List<PlaceImage> findAll();
	
	public PlaceImage findByImageName(String name);
	
	public String save(PlaceImage placeImage); 
	
	public String update(PlaceImage placeImage);
	
	public String deleteById(); 
	
}
