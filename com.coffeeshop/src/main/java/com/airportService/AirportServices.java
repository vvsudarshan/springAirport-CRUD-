package com.airportService;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AirportServices {

	public AirportServices() {
		
		System.out.println("AirportService Object Created....");
	}
	public boolean airportValidate(String airportName, String airportLocation, int noOfPlanes, int noOfRunways) {
	    boolean flag = true; 
	    
	    if (airportName == null || airportName.trim().isEmpty()) {
	        System.out.println("airportName : data not valid");
	        flag = false;
	    }

	    if (airportLocation == null || airportLocation.trim().isEmpty()) {
	        System.out.println("airportLocation : data not valid");
	        flag = false;
	    }

	    if (noOfPlanes <= 0) {
	        System.out.println("noOfPlanes : data not valid");
	        flag = false;
	    }

	    if (noOfRunways <= 0) {
	        System.out.println("noOfRunways : data not valid");
	        flag = false;
	    }

	    return flag;
	}
	public boolean airportValidate(int airportId, String airportName, String airportLocation, int noOfPlanes, int noOfRunways) {
	    boolean flag = true; 
	    if(airportId <= 0) {
	    	flag =false;
	    }
	    
	    if (airportName == null || airportName.trim().isEmpty()) {
	        System.out.println("airportName : data not valid");
	        flag = false;
	    }

	    if (airportLocation == null || airportLocation.trim().isEmpty()) {
	        System.out.println("airportLocation : data not valid");
	        flag = false;
	    }

	    if (noOfPlanes <= 0) {
	        System.out.println("noOfPlanes : data not valid");
	        flag = false;
	    }

	    if (noOfRunways <= 0) {
	        System.out.println("noOfRunways : data not valid");
	        flag = false;
	    }

	    return flag;
	}

	public boolean isExitByid(int search) {
		
		return search>=1;
	}
	public boolean isExitByName(String searchName) {
	
		return searchName != null && !searchName.trim().isEmpty();

	}
	public boolean isTableExist(List list) {
		
		return list.size()>0;
	}

	

}
