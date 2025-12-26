package org.techhub.repository;

import java.util.List;
import org.techhub.model.LocationModel;

public interface LocationRepository {

	// Adds a new location under a specified city
		public boolean addLocation(int cityId, String locationName);

		// Views all locations grouped by city
		public List<LocationModel> viewAllLocations();

		// Views locations under a specific city by city ID
		public List<LocationModel> viewLocationsByCityId(int cityId);

		// Views locations under a specific city by city name
		public List<LocationModel> viewLocationsByCityName(String cityName);

		// Deletes a location by its location ID
		public boolean deleteLocationById(int locationId);

		// Updates a location's details by its location ID
		public boolean updateLocationById(LocationModel model);
}
