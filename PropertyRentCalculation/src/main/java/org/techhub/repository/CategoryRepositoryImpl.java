package org.techhub.repository;

//import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import org.techhub.model.*;

public class CategoryRepositoryImpl extends DBConfig implements CategoryRepository {

    @Override
    public boolean isSaveCategory(PropCategoryModel model) {
        try {
            stmt = conn.prepareStatement("INSERT INTO PropCategory (catname) VALUES (?)");
            stmt.setString(1, model.getCatname());
            
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception ex) {
            System.out.println("exception is " + ex);
            return false;
        }
    }

    @Override
    public List<PropCategoryModel> viewAllCategories() {
        List<PropCategoryModel> categories = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT * FROM PropCategory ORDER BY catname");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                PropCategoryModel category = new PropCategoryModel();
                category.setCatid(rs.getInt("catid"));
                category.setCatname(rs.getString("catname"));
                categories.add(category);
            }
        } catch (Exception ex) {
            System.out.println("exception is " + ex);
        } 
        return categories;
    }

    @Override
    public boolean isDeleteCategory(int catId) {
        try {
            stmt = conn.prepareStatement("DELETE FROM PropCategory WHERE catid = ?");
            stmt.setInt(1, catId);
            
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception ex) {
            System.out.println("exception is " + ex);
            return false;
        } 
    }

    @Override
    public PropCategoryModel updateCategory(PropCategoryModel model) {
        try {
            stmt = conn.prepareStatement("UPDATE PropCategory SET catname = ? WHERE catid = ?");
            stmt.setString(1, model.getCatname());
            stmt.setInt(2, model.getCatid());
            
            int value = stmt.executeUpdate();
            if (value > 0) {
                return model;
            }
        } catch (Exception ex) {
            System.out.println("exception is " + ex);
        }
        return null;
    }
}