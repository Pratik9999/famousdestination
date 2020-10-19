package com.famousdestination.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "place")
@Getter
@Setter
@ToString 
@NoArgsConstructor
@AllArgsConstructor
public class Place {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "place_name")
	private String placeName;
	
	@Column(name = "placelocation")
	private String placelocation;
	
	@Column(name = "place_description")
	private String placeDescription;
	
	@Column(name = "place_ratings")
	private String placeRatings;
	
	
	@OneToOne(fetch = FetchType.EAGER, 
			  cascade = CascadeType.ALL)
	@JoinColumn(name = "place_img")
	private PlaceImage placeImg; 
	
	
	@OneToOne(fetch = FetchType.EAGER, 
			  cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "country_id")
	private Country country;   


}

















