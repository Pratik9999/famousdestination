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
	
	@Column(name = "placeName")
	private String placeName;
	
	@Column(name = "placelocation")
	private String placelocation;
	
	@Column(name = "placeDescription")
	private String placeDescription;
	
	@Column(name = "placeRatings")
	private String placeRatings;
	
	
	@OneToOne(fetch = FetchType.EAGER, 
			  cascade = CascadeType.ALL)
	@JoinColumn(name = "placeImg")
	private PlaceImage placeImg; 
	
	
	@OneToOne(fetch = FetchType.EAGER, 
			  cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "countryId")
	private Country country;   


}

















