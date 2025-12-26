package org.techhub.repository;


import java.util.ArrayList;
import java.util.List;
import org.techhub.model.LocationModel;
import org.techhub.model.CityModel;

public class LocationRepositoryImpl extends DBConfig implements LocationRepository {

    @Override
    public boolean addLocation(int cityId, String locationName) {
        try {
            stmt = conn.prepareStatement("insert into location (locname, cid) values(?, ?)");
            stmt.setString(1, locationName);
            stmt.setInt(2, cityId);
            
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception ex) {
            System.out.println("exception is " + ex);
            return false;
        }
    }

    @Override
    public List<LocationModel> viewAllLocations() {
        List<LocationModel> locations = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT l.locid, l.locname, c.cid, c.name as cityname FROM location l JOIN city c ON l.cid = c.cid ORDER BY c.name, l.locname");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                LocationModel location = new LocationModel();
                location.setLocid(rs.getInt("locid"));
                location.setLocname(rs.getString("locname"));
                
                CityModel city = new CityModel();
                city.setCid(rs.getInt("cid"));
                city.setName(rs.getString("cityname"));
                location.setCity(city);
                
                locations.add(location);
            }
        } catch (Exception ex) {
            System.out.println("exception is " + ex);
        } 
        return locations;
    	//return null;
    }

    @Override
    public List<LocationModel> viewLocationsByCityId(int cityId) {
        List<LocationModel> locations = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT l.locid, l.locname, c.cid, c.name as cityname FROM location l JOIN city c ON l.cid = c.cid WHERE c.cid = ? ORDER BY l.locname");
            stmt.setInt(1, cityId);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                LocationModel location = new LocationModel();
                location.setLocid(rs.getInt("locid"));
                location.setLocname(rs.getString("locname"));
                
                CityModel city = new CityModel();
                city.setCid(rs.getInt("cid"));
                city.setName(rs.getString("cityname"));
                location.setCity(city);
                
                locations.add(location);
            }
        } catch (Exception ex) {
            System.out.println("exception is " + ex);
        } 
        return locations;
    }

    @Override
    public List<LocationModel> viewLocationsByCityName(String cityName) {
        List<LocationModel> locations = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT l.locid, l.locname, c.cid, c.name as cityname FROM location l JOIN city c ON l.cid = c.cid WHERE c.name = ? ORDER BY l.locname");
            stmt.setString(1, cityName);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                LocationModel location = new LocationModel();
                location.setLocid(rs.getInt("locid"));
                location.setLocname(rs.getString("locname"));
                
                CityModel city = new CityModel();
                city.setCid(rs.getInt("cid"));
                city.setName(rs.getString("cityname"));
                location.setCity(city);
                
                locations.add(location);
            }
        } catch (Exception ex) {
            System.out.println("exception is " + ex);
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
        }
        return locations;
    }

    @Override
    public boolean deleteLocationById(int locationId) {
        try {
            stmt = conn.prepareStatement("DELETE FROM location WHERE locid = ?");
            stmt.setInt(1, locationId);
            
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception ex) {
            System.out.println("exception is " + ex);
            return false;
        } 
    }

    @Override
     public boolean updateLocationById(LocationModel model) {
        try {
            stmt = conn.prepareStatement("UPDATE location SET locname = ? WHERE locid = ?");
            stmt.setString(1, model.getLocname());
            stmt.setInt(2, model.getLocid());
            
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception ex) {
            System.out.println("exception is " + ex);
            return false;
        } 
    }
}