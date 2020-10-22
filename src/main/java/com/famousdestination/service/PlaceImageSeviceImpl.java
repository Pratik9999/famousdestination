package com.famousdestination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.famousdestination.dao.PlaceImageDAO;
import com.famousdestination.entity.PlaceImage;

@Service
public class PlaceImageSeviceImpl implements PlaceImageService {
	
	@Autowired
	private PlaceImageDAO placeImageDAO;

	@Override
	public List<PlaceImage> findAll() { 
		return null;
	}

	@Override
	public PlaceImage findByImageName(String name) {
		return placeImageDAO.findByImageName(name);
	}

	@Override
	public String save(PlaceImage placeImage) { 
		
		placeImage.setId(0);
		placeImageDAO.save(placeImage);
		
		return "saved image";
	}
	
	@Override
	public String update(PlaceImage placeImage) { 
		
		placeImageDAO.save(placeImage);
		
		return "update image";
	}

	@Override
	public String deleteById() {
		return null;
	}


}











