package org.techhub.service;

import java.util.List;

import org.techhub.model.CityModel;
import org.techhub.repository.CityRepository;
import org.techhub.repository.CityRepositoryImpl;

public class CityServiceImpl implements CityService {
	
	private static CityRepository cityServ = new CityRepositoryImpl();

	@Override
	public boolean isSavecity(CityModel model) {
		// TODO Auto-generated method stub
		return cityServ.isSavecity(model);
	}

	@Override
	public List<CityModel> getAllCities() {
		// TODO Auto-generated method stub
		return cityServ.getAllCities();
	}

	@Override
	public CityModel updateCity(CityModel model) {
		// TODO Auto-generated method stub
		return cityServ.updateCity(model);
	}

	@Override
	public boolean isDeleteCity(int propId) {
		// TODO Auto-generated method stub
		return cityServ.isDeleteCity(propId);
	}

}
