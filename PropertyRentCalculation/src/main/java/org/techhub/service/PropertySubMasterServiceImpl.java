package org.techhub.service;

import java.util.List;

import org.techhub.model.PropertySubMasterModel;
import org.techhub.repository.*;

public class PropertySubMasterServiceImpl implements PropertySubMasterService{
	public static PropertySubMasterRepository propSubMaster= new PropertySubMasterRepositoryImpl();
	
	public boolean addPropertyDetails(PropertySubMasterModel model) {
		// TODO Auto-generated method stub
		return propSubMaster.addPropertyDetails(model);
	}

	
	public List<PropertySubMasterModel> getPropertyDetailsByPropertyId(int pid) {
		// TODO Auto-generated method stub
		return propSubMaster.getPropertyDetailsByPropertyId(pid);
	}

	
	public boolean updatePropertyDetails(PropertySubMasterModel model) {
		// TODO Auto-generated method stub
		return propSubMaster.updatePropertyDetails(model);
	}

	
	public boolean deletePropertyDetails(int pid) {
		// TODO Auto-generated method stub
		return propSubMaster.deletePropertyDetails(pid);
	}

}
