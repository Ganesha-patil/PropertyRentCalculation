package org.techhub.repository;



import java.util.*;
import org.techhub.model.*;

public class CityRepositoryImpl extends DBConfig implements CityRepository {

	@Override
	public boolean isSavecity(CityModel model) {
		// TODO Auto-generated method stub
		try {
			stmt = conn.prepareStatement("insert into city (cid , name) values('0',?)");
			stmt.setString(1, model.getName());

			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("exception is " + ex);
			return false;
		}

	}

	@Override
	public List<CityModel> getAllCities() { 
		List<CityModel> cityList = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM city ORDER BY name");
			rs = stmt.executeQuery();

			while (rs.next()) {
				CityModel city = new CityModel();
				city.setCid(rs.getInt("cid"));
				city.setName(rs.getString("name"));
				cityList.add(city);
			}
		} catch (Exception ex) {
			System.out.println("Exception in getAllCities: " + ex);
			return cityList;
		}
		return cityList;
	}

	@Override
	public CityModel updateCity(CityModel model) {
        try {
            stmt = conn.prepareStatement("UPDATE city SET name = ? WHERE cid = ?");
            stmt.setString(1, model.getName());
            stmt.setInt(2, model.getCid());
            
            int value = stmt.executeUpdate();
            if (value > 0) {
                return model; // Return updated model
            }
        } catch (Exception ex) {
            System.out.println("Exception in updateCity: " + ex);
            return model;
        }
        return model;
	}

	@Override
	public boolean isDeleteCity(int cId) {
        try {
            stmt = conn.prepareStatement("DELETE FROM city WHERE cid = ?");
            stmt.setInt(1, cId);
            
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception ex) {
            System.out.println("Exception in isDeleteCity: " + ex);
            return false;
        }
		//return false;
	}

}
