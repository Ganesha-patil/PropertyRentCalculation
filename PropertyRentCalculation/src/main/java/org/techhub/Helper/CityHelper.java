package org.techhub.Helper;

import java.util.List;
import org.techhub.clientapp.ClientApp; // import ClientApp
import org.techhub.model.CityModel;
import org.techhub.service.CityService;
import org.techhub.service.CityServiceImpl;

public class CityHelper {

    public static CityService cityServ = new CityServiceImpl();

    public static void cityOperations(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter city name: ");
                String name = ClientApp.SCANNER.nextLine(); // use static Scanner

                CityModel cm = new CityModel(); 
                cm.setName(name);

                if (cityServ.isSavecity(cm)) {
                    System.out.println("City added successfully.");
                } else {
                    System.out.println("City adding failed.");
                }
                break;

            case 2:
                System.out.println("=== View All Cities ===");
                List<CityModel> cityList = cityServ.getAllCities();

                if (cityList.isEmpty()) {
                    System.out.println("No cities found!");
                } else {
                    System.out.println("ID\tCity Name");
                    System.out.println("-------------------");
                    for (CityModel city : cityList) {
                        System.out.println(city.getCid() + "\t" + city.getName());
                    }
                }
                break;
            case 3:
                System.out.print("Enter City ID to update: ");
                int updateId = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine(); // consume leftover newline

                System.out.print("Enter new City Name: ");
                String newName = ClientApp.SCANNER.nextLine();

                CityModel updateModel = new CityModel();
                updateModel.setCid(updateId);
                updateModel.setName(newName);

                CityModel updatedCity = cityServ.updateCity(updateModel);
                if (updatedCity != null) {
                    System.out.println("City updated successfully.");
                } else {
                    System.out.println("City update failed or city not found.");
                }
                break;

            case 4:
                System.out.print("Enter City ID to delete: ");
                int cityId = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine(); // consume leftover newline

                if (cityServ.isDeleteCity(cityId)) {
                    System.out.println("City deleted successfully.");
                } else {
                    System.out.println("City deletion failed or city not found.");
                }
                break;

            default:
                System.out.println("Invalid choice! Please try again.");
                break;

           
        }
    }
}


            
       