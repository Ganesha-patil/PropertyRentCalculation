package org.techhub.repository;

import java.util.List;

import org.techhub.model.PropertySubMasterModel;

public interface PropertySubMasterRepository {

	public boolean addPropertyDetails(PropertySubMasterModel model);
    public List<PropertySubMasterModel> getPropertyDetailsByPropertyId(int pid);
    public boolean updatePropertyDetails(PropertySubMasterModel model);
    public boolean deletePropertyDetails(int pid) ;

    
}
