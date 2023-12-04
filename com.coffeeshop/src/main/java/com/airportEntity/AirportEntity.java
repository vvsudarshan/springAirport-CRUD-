package com.airportEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "airport")
public class AirportEntity {
	
	@Column(name="airport_id")
	@Id
	private int airport_id;
	

	@Column(name="airport_name")
	private String airport_name;
	
	@Column(name="airport_location")
	private String airport_location;
	
	@Column(name="no_of_planes")
	private int no_of_planes;
	
	@Column(name="no_of_runways")
	private int no_of_runways;
	
	
	
	
	
	public AirportEntity() {
		
	}
	public AirportEntity(String airport_name) {
		
		this.airport_name = airport_name;
		
	}
	

	public AirportEntity(int airport_id, String airport_name, String airport_location, int no_of_planes,
			int no_of_runways) {
		this.airport_id = airport_id;
		this.airport_name = airport_name;
		this.airport_location = airport_location;
		this.no_of_planes = no_of_planes;
		this.no_of_runways = no_of_runways;
	}
	public AirportEntity(String airport_name,
			String airport_location, int no_of_planes,int no_of_runways) {
		this.airport_name = airport_name;
		this.airport_location = airport_location;
		this.no_of_planes = no_of_planes;
		this.no_of_runways = no_of_runways;
	}

	public int getAirport_id() {
		return airport_id;
	}
	public void setAirport_id(int airport_id) {
		this.airport_id = airport_id;
	}
	
	public String getAirport_name() {
		return airport_name;
	}



	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}



	public String getAirport_location() {
		return airport_location;
	}



	public void setAirport_location(String airport_location) {
		this.airport_location = airport_location;
	}



	public int getNo_of_planes() {
		return no_of_planes;
	}



	public void setNo_of_planes(int no_of_planes) {
		this.no_of_planes = no_of_planes;
	}



	public int getNo_of_runways() {
		return no_of_runways;
	}



	public void setNo_of_runways(int no_of_runways) {
		this.no_of_runways = no_of_runways;
	}
	
	@Override
	public String toString() {
		
		return "[" + airport_id + " "+airport_name+" "+airport_location+" "+no_of_planes+" "+no_of_runways +"]"; 
	}
	
	
	
	
	

}
