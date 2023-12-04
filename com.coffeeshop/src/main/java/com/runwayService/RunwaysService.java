package com.runwayService;

import javax.naming.directory.InvalidAttributesException;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


@Component
public class RunwaysService {
	public RunwaysService() {
		System.out.println("RunwaysService() invocked");
	}
	
	
	
	public boolean ValidateRunway(int runwaylength, int runwayWidth, String suit,String direction) {
		boolean flag=false;
		if(runwaylength>0) {
			flag=true;
		}
		else {
			throw new IllegalArgumentException("Enter Correct output...");
		}
		if(runwayWidth>0) {
			flag=true;
		}
		else {
			throw new IllegalArgumentException("Enter Correct output...");
			
		}
		if(suit!=null) {
			flag=true;
		}
		else {			
			throw new IllegalArgumentException("Enter Correct output...");
		}
		if(direction!=null) {
			flag=true;
		}
		else {
			throw new IllegalArgumentException("Enter Correct output...");
		}
		return flag;
		
	}

}
