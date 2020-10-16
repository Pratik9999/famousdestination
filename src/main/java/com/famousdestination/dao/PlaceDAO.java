package com.famousdestination.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.famousdestination.entity.Place;

public interface PlaceDAO extends JpaRepository<Place, Integer> {
	
	@Query("select p from Place p where p.country.countryName like %:name%") 
	public List<Place> getPlacesByCountryName(@Param("name") String name); 
	
}


























