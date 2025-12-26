package org.techhub.service;

import java.util.List;

import org.techhub.model.*;
import org.techhub.repository.*;

public class PropertyServiceImpl implements PropertyService {
	
	private static PropertyRepository propRepo = new PropertyRepositoryImpl();

	@Override
	public boolean isSaveProperty(PropertyModel model) {
		// TODO Auto-generated method stub
		return propRepo.isSaveProperty(model);
	}

	@Override
	public List<PropertyModel> viewPropertiesByCity(String cityName) {
		// TODO Auto-generated method stub
		return propRepo.viewPropertiesByCity(cityName);
	}

	@Override
	public List<PropertyModel> viewPropertiesByLocation(String locationName) {
		// TODO Auto-generated method stub
		return propRepo.viewPropertiesByLocation(locationName);
	}

	@Override
	public List<PropertyModel> viewPropertiesByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return propRepo.viewPropertiesByCategory(categoryName);
	}

	@Override
	public boolean isDeleteProperty(int propId) {
		// TODO Auto-generated method stub
		return propRepo.isDeleteProperty(propId);
	}

	@Override
	public boolean updateProperty(PropertyModel model) {
		// TODO Auto-generated method stub
		return propRepo.updateProperty(model);
	}
	
}
