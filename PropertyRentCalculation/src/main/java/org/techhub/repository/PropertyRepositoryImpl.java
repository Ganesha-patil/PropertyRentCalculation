package org.techhub.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.techhub.model.*;


public class PropertyRepositoryImpl extends DBConfig implements PropertyRepository {

    @Override
    public boolean isSaveProperty(PropertyModel model) {
        try {
            stmt = conn.prepareStatement(
                "INSERT INTO PropertyMaster (propname, address, locid, catid) VALUES (?, ?, ?, ?)"
            );
            stmt.setString(1, model.getPropname());
            stmt.setString(2, model.getAddress());
            stmt.setInt(3, model.getLocation().getLocid());
            stmt.setInt(4, model.getCategory().getCatid());

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (Exception ex) {
            System.out.println("Exception in isSaveProperty: " + ex);
            return false;
        } 
    }

    @Override
    public List<PropertyModel> viewPropertiesByCity(String cityName) {
        List<PropertyModel> properties = new ArrayList<>();
        try {
            String query = "SELECT pm.pid, pm.propname, pm.address, " +
                           "l.locid, l.locname, " +
                           "c.cid, c.name AS cityname, " +
                           "pc.catid, pc.catname " +
                           "FROM PropertyMaster pm " +
                           "JOIN Location l ON pm.locid = l.locid " +
                           "JOIN City c ON l.cid = c.cid " +
                           "JOIN PropCategory pc ON pm.catid = pc.catid " +
                           "WHERE c.name = ? ORDER BY pm.propname";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, cityName);
            rs = stmt.executeQuery();

            while (rs.next()) {
                properties.add(extractPropertyFromResultSet(rs));
            }
        } catch (Exception ex) {
            System.out.println("Exception in viewPropertiesByCity: " + ex);
        } 
        return properties;
    }

    @Override
    public List<PropertyModel> viewPropertiesByLocation(String locationName) {
        List<PropertyModel> properties = new ArrayList<>();
        try {
            String query = "SELECT pm.pid, pm.propname, pm.address, " +
                           "l.locid, l.locname, " +
                           "c.cid, c.name AS cityname, " +
                           "pc.catid, pc.catname " +
                           "FROM PropertyMaster pm " +
                           "JOIN Location l ON pm.locid = l.locid " +
                           "JOIN City c ON l.cid = c.cid " +
                           "JOIN PropCategory pc ON pm.catid = pc.catid " +
                           "WHERE l.locname = ? ORDER BY pm.propname";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, locationName);
            rs = stmt.executeQuery();

            while (rs.next()) {
                properties.add(extractPropertyFromResultSet(rs));
            }
        } catch (Exception ex) {
            System.out.println("Exception in viewPropertiesByLocation: " + ex);
        } 
        return properties;
    }

    @Override
    public List<PropertyModel> viewPropertiesByCategory(String categoryName) {
        List<PropertyModel> properties = new ArrayList<>();
        try {
            String query = "SELECT pm.pid, pm.propname, pm.address, " +
                           "l.locid, l.locname, " +
                           "c.cid, c.name AS cityname, " +
                           "pc.catid, pc.catname " +
                           "FROM PropertyMaster pm " +
                           "JOIN Location l ON pm.locid = l.locid " +
                           "JOIN City c ON l.cid = c.cid " +
                           "JOIN PropCategory pc ON pm.catid = pc.catid " +
                           "WHERE pc.catname = ? ORDER BY pm.propname";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, categoryName);
            rs = stmt.executeQuery();

            while (rs.next()) {
                properties.add(extractPropertyFromResultSet(rs));
            }
        } catch (Exception ex) {
            System.out.println("Exception in viewPropertiesByCategory: " + ex);
        } 
        return properties;
    }

    @Override
    public boolean isDeleteProperty(int propId) {
        try {
            stmt = conn.prepareStatement("DELETE FROM PropertyMaster WHERE pid = ?");
            stmt.setInt(1, propId);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (Exception ex) {
            System.out.println("Exception in isDeleteProperty: " + ex);
            return false;
        } 
    }

    @Override
    public boolean updateProperty(PropertyModel model) {
        try {
            stmt = conn.prepareStatement(
                "UPDATE PropertyMaster SET propname = ?, address = ?, locid = ?, catid = ? WHERE pid = ?"
            );
            stmt.setString(1, model.getPropname());
            stmt.setString(2, model.getAddress());
            stmt.setInt(3, model.getLocation().getLocid());
            stmt.setInt(4, model.getCategory().getCatid());
            stmt.setInt(5, model.getPid());

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (Exception ex) {
            System.out.println("Exception in updateProperty: " + ex);
            return false;
        } 
    }

    // Helper method to convert ResultSet to PropertyModel
    private PropertyModel extractPropertyFromResultSet(ResultSet rs) throws SQLException {
        PropertyModel property = new PropertyModel();
        property.setPid(rs.getInt("pid"));
        property.setPropname(rs.getString("propname"));
        property.setAddress(rs.getString("address"));

        // Location
        LocationModel location = new LocationModel();
        location.setLocid(rs.getInt("locid"));
        location.setLocname(rs.getString("locname"));

        // City
        CityModel city = new CityModel();
        city.setCid(rs.getInt("cid"));
        city.setName(rs.getString("cityname"));
        location.setCity(city);

        property.setLocation(location);

        // Category
        PropCategoryModel category = new PropCategoryModel();
        category.setCatid(rs.getInt("catid"));
        category.setCatname(rs.getString("catname"));
        property.setCategory(category);

        return property;
    }
}
