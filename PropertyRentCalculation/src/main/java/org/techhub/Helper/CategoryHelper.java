package org.techhub.Helper;

import java.util.List;
import org.techhub.clientapp.ClientApp;
import org.techhub.model.PropCategoryModel;
import org.techhub.service.CategoryService;
import org.techhub.service.CategoryServiceImpl;

public class CategoryHelper {
    public static CategoryService categoryServ = new CategoryServiceImpl();

    public static void categoryOperations(int choice) {
        switch (choice) {
            case 1:
                // Add category
                System.out.print("Enter Category Name (e.g., Furnished, Semi-Furnished, Non-Furnished): ");
                String catName = ClientApp.SCANNER.nextLine();
                
                PropCategoryModel category = new PropCategoryModel();
                category.setCatname(catName);
                
                if (categoryServ.isSaveCategory(category)) {
                    System.out.println("Category added successfully.");
                } else {
                    System.out.println("Category adding failed.");
                }
                break;

            case 2:
                // View all categories
                System.out.println("=== All Property Categories ===");
                List<PropCategoryModel> categories = categoryServ.viewAllCategories();
                if (categories.isEmpty()) {
                    System.out.println("No categories found!");
                } else {
                    System.out.println("ID\tCategory Name");
                    System.out.println("-------------------");
                    for (PropCategoryModel cat : categories) {
                        System.out.println(cat.getCatid() + "\t" + cat.getCatname());
                    }
                }
                break;

            case 3:
                // Delete category using id
                System.out.print("Enter Category ID to delete: ");
                int catId = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();
                
                if (categoryServ.isDeleteCategory(catId)) {
                    System.out.println("Category deleted successfully.");
                } else {
                    System.out.println("Category deletion failed or category not found.");
                }
                break;

            case 4:
                // Update category using id
                System.out.print("Enter Category ID to update: ");
                int updateCatId = ClientApp.SCANNER.nextInt();
                ClientApp.SCANNER.nextLine();
                
                System.out.print("Enter new Category Name: ");
                String newCatName = ClientApp.SCANNER.nextLine();
                
                PropCategoryModel updateCat = new PropCategoryModel();
                updateCat.setCatid(updateCatId);
                updateCat.setCatname(newCatName);
                
                PropCategoryModel updatedCategory = categoryServ.updateCategory(updateCat);
                if (updatedCategory != null) {
                    System.out.println("Category updated successfully.");
                } else {
                    System.out.println("Category update failed or category not found.");
                }
                break;

            default:
                System.out.println("Invalid choice! Please try again.");
                break;
        }
    }
}