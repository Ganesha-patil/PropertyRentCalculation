package org.techhub.repository;

import java.util.ArrayList;
import java.util.List;

//import java.sql.*;
import org.techhub.model.PropertySubMasterModel;

public class PropertySubMasterRepositoryImpl extends DBConfig implements PropertySubMasterRepository {

    @Override
    public boolean addPropertyDetails(PropertySubMasterModel model) {
        try {
            stmt = conn.prepareStatement("INSERT INTO PropertySubMaster (pid, area, ratepersqfeet) VALUES (?, ?, ?)");
            stmt.setInt(1, model.getPid());
            stmt.setInt(2, model.getArea());
            stmt.setInt(3, model.getRatepersqfeet());
            
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception ex) {
            System.out.println("exception is " + ex);
            return false;
        }
    }

    @Override
    public List<PropertySubMasterModel> getPropertyDetailsByPropertyId(int pid) {
        List<PropertySubMasterModel> subProps = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT * FROM PropertySubMaster WHERE pid = ?");
            stmt.setInt(1, pid);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                PropertySubMasterModel details = new PropertySubMasterModel();
                details.setAid(rs.getInt("aid"));
                details.setPid(rs.getInt("pid"));
                details.setArea(rs.getInt("area"));
                details.setRatepersqfeet(rs.getInt("ratepersqfeet"));
                subProps.add(details);
            }
            return subProps;
        } catch (Exception ex) {
            System.out.println("exception is " + ex);
        }
		return subProps;
    }

    @Override
    public boolean updatePropertyDetails(PropertySubMasterModel model) {
        try {
            stmt = conn.prepareStatement("UPDATE PropertySubMaster SET area = ?, ratepersqfeet = ? WHERE pid = ?");
            stmt.setInt(1, model.getArea());
            stmt.setInt(2, model.getRatepersqfeet());
            stmt.setInt(3, model.getPid());
            
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception ex) {
            System.out.println("exception is " + ex);
            return false;
        } 
    }

    @Override
    public boolean deletePropertyDetails(int pid) {
        try {
            stmt = conn.prepareStatement("DELETE FROM PropertySubMaster WHERE pid = ?");
            stmt.setInt(1, pid);
            
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception ex) {
            System.out.println("exception is " + ex);
            return false;
        } 
    }
}