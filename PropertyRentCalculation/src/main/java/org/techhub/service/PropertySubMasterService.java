package org.techhub.service;

import java.util.List;

import org.techhub.model.PropertySubMasterModel;

public interface PropertySubMasterService {

	
	public boolean addPropertyDetails(PropertySubMasterModel model);
    public boolean updatePropertyDetails(PropertySubMasterModel model);
    public boolean deletePropertyDetails(int pid) ;
	public List<PropertySubMasterModel> getPropertyDetailsByPropertyId(int viewPid);
}
