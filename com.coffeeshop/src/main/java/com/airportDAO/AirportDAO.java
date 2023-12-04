package com.airportDAO;

import java.util.List;

import com.airportEntity.AirportEntity;

public interface AirportDAO {
	public boolean saveAirportEntity(AirportEntity entity);
	
	public AirportEntity getAirportEntityById(int id);
	public AirportEntity getAirportEntityByName(String searchName);
	public boolean deleteById(int Id);
	public boolean deleteByName(String Name);
	public List<AirportEntity> getAllAirportEntity();
	public boolean updateAirportById(AirportEntity entity);
	

}
