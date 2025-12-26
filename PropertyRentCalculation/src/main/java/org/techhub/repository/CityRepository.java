package org.techhub.repository;

import java.util.List;

import org.techhub.model.CityModel;

public interface CityRepository {


	public boolean isSavecity (CityModel model);
	public List<CityModel> getAllCities();
	public CityModel updateCity (CityModel model);
	public boolean isDeleteCity(int cId);
}
