package org.techhub.Helper;

import org.techhub.service.*;

//import org.techhub.Helper.*;

import java.util.*;

import org.techhub.clientapp.ClientApp;
import org.techhub.model.*;
public class LocationHelper {
	public static LocationService locationServ= new LocationServiceImpl();
	//private static CityHelper cityHelp = new CityHelper(); 
	
	
	// we have this every time created static method
	public static void cities()
	{	
        // First show all cities so user can choose
        System.out.println("\nAvailable Cities:");
        List<CityModel> cities = CityHelper.cityServ.getAllCities();
        if (cities.isEmpty()) {
            System.out.println("No cities found! Please add a city first.");
        }
        System.out.println("ID\tCity Name");
        System.out.println("-------------------");
        for (CityModel city : cities) {
            System.out.println(city.getCid() + "\t" + city.getName());
        }
      }
	
	public static void locationOperations(int chioce)
	{
		
	    switch (chioce) {
        case 1:
            // Add New Location under specified City
            System.out.println("=== Add New Location ===");
                     
            cities();// First show all cities so user can choose
            System.out.print("\nEnter City ID: ");
            int cityId = ClientApp.SCANNER.nextInt();
            ClientApp.SCANNER.nextLine();
            
            System.out.print("Enter Location Name: ");
            String locName = ClientApp.SCANNER.nextLine();
            
            LocationModel lm = new LocationModel();
            lm.setLocname(locName);
            CityModel city = new CityModel();
            city.setCid(cityId);
            lm.setCity(city);
            
            if (locationServ.addLocation(cityId, locName)) {
                System.out.println("Location added successfully...............");
            } else {
                System.out.println("Location adding not successful...............");
            }
            break;
            
            
        case 2:
           System.out.println("=== All Locations (City-wise) ===");
//
            List<LocationModel> locations = locationServ.viewAllLocations();

        	Map<Integer, List<LocationModel>> cityMap = new LinkedHashMap<>();

        	for (LocationModel loc : locations) {
        		//gets id from =locationModel.cityReffrom.methodgetCity()
        	    cityId = loc.getCity().getCid();
        	    cityMap.computeIfAbsent(cityId, k -> new ArrayList<>()).add(loc);
        	}

        	for (Map.Entry<Integer, List<LocationModel>> entry : cityMap.entrySet()) {
        	     cityId = entry.getKey();
        	    List<LocationModel> locList = entry.getValue();

        	    CityModel city1 = locList.get(0).getCity(); // get city name

        	    System.out.println("\nCity: " + city1.getName() + " (ID: " + city1.getCid() + ")");
        	    System.out.println("Locations:");

        	    for (LocationModel loc : locList) {
        	        System.out.println("  " + loc.getLocid() + ". " + loc.getLocname());
        	    }
        	}

            break;

        case 3:
            // Input City ID and View Locations under that City
            System.out.println("=== View Locations by City ID ===");
            cities();
            System.out.print("Enter City ID: ");
            int searchCityId = ClientApp.SCANNER.nextInt();
            ClientApp.SCANNER.nextLine();
            
            List<LocationModel> locationsById = locationServ.viewLocationsByCityId(searchCityId);
            if (locationsById.isEmpty()) {
                System.out.println("No locations found for City ID: " + searchCityId);
            } else {
                System.out.println("\nLocations in City ID " + searchCityId + ":");
                System.out.println("ID\tLocation Name");
                System.out.println("-------------------");
                for (LocationModel loc : locationsById) {
                    System.out.println(loc.getLocid() + "\t" + loc.getLocname());
                }
            }
            break;
            
        case 4:
            // Input City Name and Show Locations under that City
            System.out.println("=== View Locations by City Name ===");
            cities();
            System.out.print("Enter City Name: ");
            String cityName = ClientApp.SCANNER.nextLine();
            
            List<LocationModel> locationsByName = locationServ.viewLocationsByCityName(cityName);
            if (locationsByName.isEmpty()) {
                System.out.println("No locations found for City: " + cityName);
            } else {
                System.out.println("\nLocations in " + cityName + ":");
                System.out.println("ID\tLocation Name");
                System.out.println("-------------------");
                for (LocationModel loc : locationsByName) {
                    System.out.println(loc.getLocid() + "\t" + loc.getLocname());
                }
            }
            break;
            
        case 5:
            // Delete Location by ID
            System.out.println("=== Delete Location ===");
            System.out.print("Enter Location ID to delete: ");
            int locIdToDelete = ClientApp.SCANNER.nextInt();
            ClientApp.SCANNER.nextLine();
            
            if (locationServ.deleteLocationById(locIdToDelete)) {
                System.out.println("Location deleted successfully...............");
            } else {
                System.out.println("Location deletion failed or location not found...............");
            }
            break;
            
            
        case 6:

            System.out.println("=== Update Location ===");
            System.out.print("Enter Location ID to update: ");
             int updateLocId = ClientApp.SCANNER.nextInt();
             ClientApp.SCANNER.nextLine();
            
            System.out.print("Enter new Location Name: ");
            String newLocName = ClientApp.SCANNER.nextLine();
            
            LocationModel updateModel = new LocationModel();
            updateModel.setLocid(updateLocId);
            updateModel.setLocname(newLocName);

             boolean isUpadted = locationServ.updateLocationById(updateModel);
            if (isUpadted) {
                System.out.println("Location updated successfully...............");
            } else {
                System.out.println("Location update failed or location not found...............");
            }
            break;
            
	    }
	}

}
