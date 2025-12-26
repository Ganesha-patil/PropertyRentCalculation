package org.techhub.Helper;

import java.util.List;
import org.techhub.clientapp.ClientApp;
import org.techhub.model.PropertyModel;
import org.techhub.model.LocationModel;
import org.techhub.model.PropCategoryModel;
import org.techhub.service.PropertyService;
import org.techhub.service.PropertyServiceImpl;
import org.techhub.service.LocationService;
import org.techhub.service.LocationServiceImpl;
import org.techhub.service.CategoryService;
import org.techhub.service.CategoryServiceImpl;

public class PropertyHelper {

    public static PropertyService propertyServ = new PropertyServiceImpl();
    public static LocationService locationServ = new LocationServiceImpl();
    public static CategoryService categoryServ = new CategoryServiceImpl();

    public static void propertyOperations(int choice) {
        switch (choice) {
            case 1:
                // Add new property
                System.out.println("=== Add New Property ===");

                // Show all locations
                List<LocationModel> locations = locationServ.viewAllLocations();
                if (locations.isEmpty()) {
                    System.out.println("No locations found! Please add a location first.");
                    break;
                }
                System.out.println("Location ID\tLocation Name\tCity");
                System.out.println("--------------------------------------");
                for (LocationModel loc : locations) {
                    System.out.println(loc.getLocid() + "\t\t" + loc.getLocname() + "\t\t" + loc.getCity().getName());
                }

                System.out.print("\nEnter Location ID: ");
                int locId = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();

                // Show all categories
                List<PropCategoryModel> categories = categoryServ.viewAllCategories();
                if (categories.isEmpty()) {
                    System.out.println("No categories found! Please add a category first.");
                    break;
                }
                System.out.println("ID\tCategory Name");
                System.out.println("-------------------");
                for (PropCategoryModel cat : categories) {
                    System.out.println(cat.getCatid() + "\t" + cat.getCatname());
                }

                System.out.print("\nEnter Category ID: ");
                int catId = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();

                System.out.print("Enter Property Name: ");
                String propName = ClientApp.SCANNER.nextLine();

                System.out.print("Enter Property Address: ");
                String address = ClientApp.SCANNER.nextLine();

                PropertyModel property = new PropertyModel();
                property.setPropname(propName);
                property.setAddress(address);

                // Set Location
                LocationModel location = new LocationModel();
                location.setLocid(locId);
                property.setLocation(location);

                // Set Category
                PropCategoryModel category = new PropCategoryModel();
                category.setCatid(catId);
                property.setCategory(category);

                if (propertyServ.isSaveProperty(property)) {
                    System.out.println("Property added successfully.");
                } else {
                    System.out.println("Property adding failed.");
                }
                break;

            case 2:
                // View properties city-wise
                System.out.println("=== View Properties by City ===");
                System.out.print("Enter City Name: ");
                String cityName = ClientApp.SCANNER.nextLine();

                List<PropertyModel> cityProperties = propertyServ.viewPropertiesByCity(cityName);
                if (cityProperties.isEmpty()) {
                    System.out.println("No properties found in city: " + cityName);
                } else {
                    System.out.println("\nProperties in " + cityName + ":");
                    System.out.println("ID\tProperty Name\tAddress\tLocation\tCategory");
                    System.out.println("------------------------------------------------------------");
                    for (PropertyModel prop : cityProperties) {
                        System.out.println(prop.getPid() + "\t" + prop.getPropname() + "\t" +
                                prop.getAddress() + "\t" +
                                prop.getLocation().getLocname() + "\t" +
                                prop.getCategory().getCatname());
                    }
                }
                break;

            case 3:
                // View properties location-wise
                System.out.println("=== View Properties by Location ===");
                System.out.print("Enter Location Name: ");
                String locationName = ClientApp.SCANNER.nextLine();

                List<PropertyModel> locProperties = propertyServ.viewPropertiesByLocation(locationName);
                if (locProperties.isEmpty()) {
                    System.out.println("No properties found in location: " + locationName);
                } else {
                    System.out.println("\nProperties in " + locationName + ":");
                    System.out.println("ID\tProperty Name\tAddress\tCategory");
                    System.out.println("--------------------------------------------------");
                    for (PropertyModel prop : locProperties) {
                        System.out.println(prop.getPid() + "\t" + prop.getPropname() + "\t" +
                                prop.getAddress() + "\t" +
                                prop.getCategory().getCatname());
                    }
                }
                break;

            case 4:
                // View properties category-wise
                System.out.println("=== View Properties by Category ===");
                List<PropCategoryModel> allCategories = categoryServ.viewAllCategories();
                if (allCategories.isEmpty()) {
                    System.out.println("No categories found!");
                    break;
                }
                System.out.println("ID\tCategory Name");
                System.out.println("-------------------");
                for (PropCategoryModel cat : allCategories) {
                    System.out.println(cat.getCatid() + "\t" + cat.getCatname());
                }

                System.out.print("\nEnter Category Name: ");
                String categoryName = ClientApp.SCANNER.nextLine();

                List<PropertyModel> catProperties = propertyServ.viewPropertiesByCategory(categoryName);
                if (catProperties.isEmpty()) {
                    System.out.println("No properties found in category: " + categoryName);
                } else {
                    System.out.println("\nProperties in " + categoryName + " category:");
                    System.out.println("ID\tProperty Name\tAddress\tLocation");
                    System.out.println("----------------------------------------------");
                    for (PropertyModel prop : catProperties) {
                        System.out.println(prop.getPid() + "\t" + prop.getPropname() + "\t" +
                                prop.getAddress() + "\t" +
                                prop.getLocation().getLocname());
                    }
                }
                break;

            case 5:
                // Delete property
                System.out.println("=== Delete Property ===");
                System.out.print("Enter Property ID to delete: ");
                int propId = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();

                if (propertyServ.isDeleteProperty(propId)) {
                    System.out.println("Property deleted successfully.");
                } else {
                    System.out.println("Property deletion failed or property not found.");
                }
                break;

            case 6:
                // Update property
                System.out.println("=== Update Property ===");
                System.out.print("Enter Property ID to update: ");
                int updatePropId = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();

                // Locations
                List<LocationModel> allLocations = locationServ.viewAllLocations();
                System.out.println("Location ID\tLocation Name\tCity");
                System.out.println("--------------------------------------");
                for (LocationModel loc : allLocations) {
                    System.out.println(loc.getLocid() + "\t\t" + loc.getLocname() + "\t\t" + loc.getCity().getName());
                }
                System.out.print("\nEnter new Location ID: ");
                int newLocId = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();

                // Categories
                List<PropCategoryModel> allCats = categoryServ.viewAllCategories();
                System.out.println("ID\tCategory Name");
                System.out.println("-------------------");
                for (PropCategoryModel cat : allCats) {
                    System.out.println(cat.getCatid() + "\t" + cat.getCatname());
                }
                System.out.print("\nEnter new Category ID: ");
                int newCatId = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();

                System.out.print("Enter new Property Name: ");
                String newPropName = ClientApp.SCANNER.nextLine();

                System.out.print("Enter new Property Address: ");
                String newAddress = ClientApp.SCANNER.nextLine();

                PropertyModel updateProp = new PropertyModel();
                updateProp.setPid(updatePropId);
                updateProp.setPropname(newPropName);
                updateProp.setAddress(newAddress);

                LocationModel newLocation = new LocationModel();
                newLocation.setLocid(newLocId);
                updateProp.setLocation(newLocation);

                PropCategoryModel newCategory = new PropCategoryModel();
                newCategory.setCatid(newCatId);
                updateProp.setCategory(newCategory);

                boolean updatedProperty = propertyServ.updateProperty(updateProp);
                if (updatedProperty) {
                    System.out.println("Property updated successfully.");
                } else {
                    System.out.println("Property update failed or property not found.");
                }
                break;

            default:
                System.out.println("Invalid choice! Please try again.");
                break;
        }
    }
}
