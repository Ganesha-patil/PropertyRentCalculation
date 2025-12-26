package org.techhub.Helper;


import java.util.List;

import org.techhub.clientapp.ClientApp;
import org.techhub.model.PropertySubMasterModel;
import org.techhub.service.PropertySubMasterService;
import org.techhub.service.PropertySubMasterServiceImpl;

public class PropertySubMasterHelper {
    
    public static PropertySubMasterService subMasterServ = new PropertySubMasterServiceImpl();

    public static void propertySubMasterOperations(int choice) {
        switch (choice) {
            case 1:
                // addPropertyDetails
                System.out.println("=== Add Property Details ===");
                System.out.print("Enter Property ID: ");
                int pid = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();
                
                System.out.print("Enter Area (in sq. feet): ");
                int area = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();
                
                System.out.print("Enter Rate per sq. feet: ");
                int rate = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();
                
                PropertySubMasterModel details = new PropertySubMasterModel();
                details.setPid(pid);
                details.setArea(area);
                details.setRatepersqfeet(rate);
                
                boolean addResult = subMasterServ.addPropertyDetails(details);
                if (addResult) {
                    System.out.println("Property details added successfully.");
                } else {
                    System.out.println("Failed to add property details.");
                }
                break;
                
            case 2:
                // getPropertyDetailsByPropertyId (now returns List)
                System.out.println("=== View Property Details ===");
                System.out.print("Enter Property ID: ");
                int viewPid = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();
                
                List<PropertySubMasterModel> propertyDetails = subMasterServ.getPropertyDetailsByPropertyId(viewPid);
                if (propertyDetails.isEmpty()) {
                    System.out.println("No details found for Property ID: " + viewPid);
                } else {
                    System.out.println("\n=== Property Details for ID: " + viewPid + " ===");
                    System.out.println("Detail ID\tArea (sq. ft)\tRate per sq. ");
                    System.out.println("-------------------------------------------------------------");
                    for (PropertySubMasterModel detail : propertyDetails) {
                        int rate1 = detail.getArea() * detail.getRatepersqfeet();
                        System.out.println(detail.getAid() + "\t\t" + 
                                         detail.getArea() + "\t\t"  + 
                                         rate1);
                        // ft\tTotal Rate+ detail.getRatepersqfeet() + "\t\t"
                    }
                }
                break;
            case 3: 
                // updatePropertyDetails
                System.out.println("=== Update Property Details ===");
                System.out.print("Enter Main Property ID to update: ");
                int updatePid = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();
                
                System.out.print("Enter new Area in sq. feet : ");
                int newArea = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();
                
                System.out.print("Enter new Rate per sq. feet: ");
                int newRate = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();
                
                PropertySubMasterModel updateDetails = new PropertySubMasterModel();
                updateDetails.setPid(updatePid);
                updateDetails.setArea(newArea);
                updateDetails.setRatepersqfeet(newRate);
                
                boolean updateResult = subMasterServ.updatePropertyDetails(updateDetails);
                if (updateResult) {
                    System.out.println("Property details updated successfully.");
                } else {
                    System.out.println("Failed to update property details.");
                }
                break;
                
            case 4:
                // deletePropertyDetails
                System.out.println("=== Delete Property Details ===");
                System.out.print("Enter Property ID to delete details: ");
                int deletePid = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();
                
                boolean deleteResult = subMasterServ.deletePropertyDetails(deletePid);
                if (deleteResult) {
                    System.out.println("Property details deleted successfully.");
                } else {
                    System.out.println("Failed to delete property details.");
                }
                break;
            case 5:
                System.out.println("=== View Property Details ===");
                System.out.print("Enter Property ID: ");
                viewPid = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();
                //List<PropertySubMasterModel>
                 propertyDetails = subMasterServ.getPropertyDetailsByPropertyId(viewPid);
                if (propertyDetails.isEmpty()) {
                    System.out.println("No details found for Property ID: " + viewPid);
                } else {
                    System.out.println("\n=== Property Details for ID: " + viewPid + " ===");
                    System.out.println("Detail ID\tArea (sq. ft)\tRate per sq. ft\tTotal Rate");
                    System.out.println("-------------------------------------------------------------");
                    for (PropertySubMasterModel detail : propertyDetails) {
                        int rate1 = detail.getArea() * detail.getRatepersqfeet();
                        System.out.println(detail.getAid() + "\t\t" + 
                                         detail.getArea() + "\t\t" +
                                         detail.getRatepersqfeet() + "\t\t" + 
                                         rate1);
                    }
                }
                break;
                
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
}