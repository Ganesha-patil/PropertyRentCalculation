package org.techhub.service;

import java.util.List;

import org.techhub.model.*;
import org.techhub.repository.*;


public class LocationServiceImpl implements LocationService {

	//private static LocationRepository locRepo = new LocationRepositoryImpl();
	private static LocationRepository locRepo = new LocationRepositoryImpl();
	@Override
	public boolean addLocation(int cityId, String locationName) {
		// TODO Auto-generated method stub
		return locRepo.addLocation(cityId, locationName);
	}

	@Override
	public List<LocationModel> viewAllLocations() {
		// TODO Auto-generated method stub
		return locRepo.viewAllLocations();
	}

	@Override
	public List<LocationModel> viewLocationsByCityId(int cityId) {
		// TODO Auto-generated method stub
		return locRepo.viewLocationsByCityId(cityId);
	}

	@Override
	public List<LocationModel> viewLocationsByCityName(String cityName) {
		// TODO Auto-generated method stub
		return locRepo.viewLocationsByCityName(cityName);
	}

	@Override
	public boolean deleteLocationById(int locationId) {
		// TODO Auto-generated method stub
		return locRepo.deleteLocationById(locationId);
	}
	
	@Override
	public boolean updateLocationById(LocationModel model) {
		// TODO Auto-generated method stub
		return locRepo.updateLocationById(model);
	}

}
