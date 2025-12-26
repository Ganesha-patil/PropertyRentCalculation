package org.techhub.clientapp;

import java.util.Scanner;
import org.techhub.Helper.CategoryHelper;
import org.techhub.Helper.CityHelper;
import org.techhub.Helper.LocationHelper;
import org.techhub.Helper.PropertyHelper;
import org.techhub.Helper.PropertySubMasterHelper;

public class ClientApp {

    // Static Scanner accessible globally
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
        	System.out.println("\n=====  MANAGEMENT MENU =====");
            System.out.println(" 1 : City operation");
            System.out.println(" 2 : Location operation");
            System.out.println(" 3 : Catagorey operation");
            System.out.println(" 4 : Property operation");
            System.out.println(" 5 : Sub Property operation");
            System.out.println(" 6 : calculated price of properties in a property");
            System.out.println(" 0 : Exit");
            System.out.print("Enter your choice: ");

            int choice = SCANNER.nextInt();
            SCANNER.nextLine(); // consume leftover newline

            switch (choice) {
                

                case 1:
                	System.out.println("\n===== CITY MASTER MENU =====");
                    System.out.println(" 1 : Add New City");
                    System.out.println(" 2 : View All Cities");
                    System.out.println(" 3 : Update City");
                    System.out.println(" 4 : Delete City");
                    System.out.print("Enter your choice: ");

                    int cityChoice = SCANNER.nextInt();
                    SCANNER.nextLine(); 
                    CityHelper.cityOperations(cityChoice);
                    break;
                    
                case 2:
                	
                	System.out.println("\n===== LOCATION MASTER MENU =====");
                	System.out.println(" 1 : Add New Location under specified City");
                	System.out.println(" 2 : View All Locations (city-wise)");
                	System.out.println(" 3 : View Locations by City ID");
                	System.out.println(" 4 : View Locations by City Name");
                	System.out.println(" 5 : Delete Location by ID");
                	System.out.println(" 6 : Update Location by ID");
                	System.out.print("Enter your choice: ");
                	int locationChoice = SCANNER.nextInt();
                	SCANNER.nextLine();
                	LocationHelper.locationOperations(locationChoice);
                	
                	break;
                case 3:
                	System.out.println("\n===== Category MASTER MENU =====");
                    System.out.println(" 1 : Add New Category");
                    System.out.println(" 2 : View All Category");
                    System.out.println(" 3 : Update Category");
                    System.out.println(" 4 : Delete Category");
                    System.out.print("Enter your choice: ");
                    
                    int categoryChoice = SCANNER.nextInt();
                	SCANNER.nextLine();
                	//CategoryHelper.categoryOperations(categoryChoice);
                	CategoryHelper.categoryOperations(categoryChoice);
                	break;
                    
                case 4:
                	System.out.println("\n===== Property MASTER MENU =====");
                    System.out.println(" 1 : Add New Property");
                    System.out.println(" 2 : View All Properties by City");
                    System.out.println(" 3 : View All Properties by Location");
                    System.out.println(" 4 : View All Properties by Category");
                    System.out.println(" 5 : Delete Property");
                    System.out.println(" 6 : Update Property");
                    
                    System.out.print("Enter your choice: ");
                    int propertyChoice = SCANNER.nextInt();
                    SCANNER.nextLine();
                    PropertyHelper.propertyOperations(propertyChoice);
                	break;
                	
                case 5:
                	System.out.println("\n===== Property Submaster MASTER MENU =====");
                    System.out.println(" 1 : Add New  sub Property ");
                    System.out.println(" 2 : View All sub Property");
                    System.out.println(" 3 : Update sub Property");
                    System.out.println(" 4 : Delete sub Property");
                    System.out.print("Enter your choice: ");
                    System.out.print("Enter your choice: ");
                    
                    
                    propertyChoice = SCANNER.nextInt();
                    SCANNER.nextLine();
                    PropertySubMasterHelper.propertySubMasterOperations(propertyChoice);
                    
                    break;
                case 6:
//                	 propertyChoice = SCANNER.nextInt();
//                     SCANNER.nextLine();
                     PropertySubMasterHelper.propertySubMasterOperations(5);
                	break;
                	
                case 0:
                    System.out.println("Exiting............");
                    SCANNER.close();
                    System.out.println("Scanner closed...........");
                    System.out.println("Program closed............");
                    System.exit(0);
                    
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
                    
                
            }
        }
    }
}
