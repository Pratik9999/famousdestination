package com.famousdestination.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.famousdestination.dao.PlaceDAO;
import com.famousdestination.entity.Place;
import com.famousdestination.entity.PlaceResponse;

@Service
public class PlaceServiceImpl implements PlaceService {
	
	// Place DAO
	@Autowired
	private PlaceDAO placeDAO;

	@Override
	public List<PlaceResponse> getAllPlaces() {
		
		List<Place> places =  placeDAO.findAll();
		
		List<PlaceResponse> placeResponse = new ArrayList<PlaceResponse>();
		
		for (Place place : places) {
			placeResponse.add(convertPlacetoResponse(place));
		}
		
		return placeResponse;
	}

	@Override
	public PlaceResponse getPlaceById(int theId) { 
		
		Optional<Place> result = placeDAO.findById(theId);
		
		Place place = null; 
		PlaceResponse placeResponse = null;
	
		if(result.isPresent()) {
			place = result.get();
			placeResponse = convertPlacetoResponse(place);
		}
		
		return placeResponse;
	}

	@Override
	public String savePlace(Place thePlace) {
		
		placeDAO.save(thePlace);
		return "Saved";
	}

	@Override
	public String deletePlace(int theId) {
		placeDAO.deleteById(theId);		
		return "Deleted by ID : " + theId;
	}
	
	private PlaceResponse convertPlacetoResponse(Place place) {
		
		PlaceResponse thePlaceResponse = new PlaceResponse();
		
		thePlaceResponse.setId(place.getId());
		thePlaceResponse.setPlaceName(place.getPlaceName());
		thePlaceResponse.setPlacelocation(place.getPlacelocation());
		thePlaceResponse.setPlaceDescription(place.getPlaceDescription());
		thePlaceResponse.setPlaceRatings(place.getPlaceRatings());
		// Image
		String url = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/images/")
					.path(place.getPlaceImg().getImageName())
					.toUriString();
		thePlaceResponse.setPlaceImgUrl(url);
		
		thePlaceResponse.setCountry(place.getCountry().getCountryName());
		
		return thePlaceResponse;
		
	}

	@Override
	public List<PlaceResponse> getPlacesByCountryName(String name) {
		
		List<Place> places = placeDAO.getPlacesByCountryName(name);
		
		List<PlaceResponse> placeResponse = new ArrayList<PlaceResponse>();
		
		for (Place place : places) {
			placeResponse.add(convertPlacetoResponse(place));
		}
		
		return  placeResponse;
	}

}














