package org.techhub.service;

import java.util.List;

import org.techhub.model.*;

public interface CityService {

	public boolean isSavecity (CityModel model);
	public List<CityModel> getAllCities();
	public CityModel updateCity(CityModel model);
	public boolean isDeleteCity(int cId);
}
