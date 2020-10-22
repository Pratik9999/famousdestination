package com.famousdestination.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.famousdestination.entity.Place;
import com.famousdestination.entity.PlaceImage;
import com.famousdestination.entity.PlaceResponse;
import com.famousdestination.service.PlaceImageService;
import com.famousdestination.service.PlaceService;
import com.google.gson.Gson;


@RestController
@CrossOrigin
public class Controller {
	
	@GetMapping("/") 
	public String hello() {
		return "Hello World!!!!";
	}
	
	@Autowired
	private PlaceService placeService;
	
	@Autowired
	private PlaceImageService placeImageService;
	
	
	// Get all Places
	@GetMapping("/places")
	ResponseEntity<List<PlaceResponse>> getAllPlaces() {
		
		List<PlaceResponse> placeResponse = placeService.getAllPlaces(); 
		
		return new ResponseEntity<List<PlaceResponse>>(placeResponse, HttpStatus.OK);
	}
	
	// Get all Place by id
	@GetMapping("/places/{id}")
	ResponseEntity<PlaceResponse> getPlaceById(@PathVariable int id) {
		
		PlaceResponse placeResponse =  placeService.getPlaceById(id);
		
		if(placeResponse == null) {
			throw new PlaceNotFoundException("Cannot find place id of " +  id); 
		}
		
		return new ResponseEntity<PlaceResponse>(placeResponse, HttpStatus.OK); 
	}
	
	

	// Save Place
	@PostMapping("places")
	public String savePlace(@RequestParam("data") String data, @RequestParam("image") MultipartFile Mfile) {
		
		Gson g = new Gson(); 
		Place thePlace = g.fromJson(data, Place.class);  
		
		
		PlaceImage img = null;
		try {
			 img = new PlaceImage(0, StringUtils.cleanPath(Mfile.getOriginalFilename()) , Mfile.getBytes());
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		
		thePlace.setPlaceImg(img); 

		
		return placeService.savePlace(thePlace);
	}
	
	// Update Place
	@PutMapping("/places")
	public String updatePlace(@RequestParam("data") String data, @RequestParam("image") MultipartFile Mfile) {
		
		Gson g = new Gson(); 
		Place thePlace = g.fromJson(data, Place.class);    
		
		
		PlaceImage img = null;
		try {
			 img = new PlaceImage(thePlace.getPlaceImg().getId(), StringUtils.cleanPath(Mfile.getOriginalFilename()) , Mfile.getBytes());
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		
		thePlace.setPlaceImg(img);

		
		return placeService.savePlace(thePlace);
	}
	
	// Delete Place
	@DeleteMapping("/places/{id}")
	public String deletePlaceById(@PathVariable int id) {
		return placeService.deletePlace(id); 
	} 
	
	// Get Image
	@GetMapping("/images/{name}")
	ResponseEntity<byte[]> getImageById(@PathVariable String name) {
		
		PlaceImage img = placeImageService.findByImageName(name);
		
		if(img == null) {
			throw new PlaceNotFoundException("Cannot found image with name of " + name);
		}
		
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName=" + img.getImageName())
				.body(img.getImageBytes()); 
	}
	
	// Get Places by courntry name 
	@GetMapping("/places/country/{countryName}")
	ResponseEntity<List<PlaceResponse>> getPlacesByCountryName(@PathVariable String countryName) {
		
		List<PlaceResponse> placeResponse =  placeService.getPlacesByCountryName(countryName.toLowerCase());
		
		if(placeResponse.size() == 0) {
			throw new PlaceNotFoundException("Cannot find place by country name of " + countryName);
		}
		
		return new ResponseEntity<List<PlaceResponse>>(placeResponse, HttpStatus.OK);
		
	} 
	
	// update images
	@PutMapping("/images")
	public String updateImage(@RequestParam("data") String data, @RequestParam("image") MultipartFile Mfile) {
		
		Gson g = new Gson(); 
		PlaceImage imageObj = g.fromJson(data, PlaceImage.class); 
		
		try {
			imageObj.setImageBytes(Mfile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return placeImageService.update(imageObj); 
	}

	

}










































