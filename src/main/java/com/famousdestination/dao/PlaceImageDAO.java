package com.famousdestination.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.famousdestination.entity.PlaceImage;

public interface PlaceImageDAO extends JpaRepository<PlaceImage, Integer> {
	
	public PlaceImage findByImageName(String name); 
	
}
