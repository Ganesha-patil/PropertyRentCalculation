package org.techhub.service;



import java.util.List;
import org.techhub.model.PropertyModel;

public interface PropertyService {
    boolean isSaveProperty(PropertyModel model);
    List<PropertyModel> viewPropertiesByCity(String cityName);
    List<PropertyModel> viewPropertiesByLocation(String locationName);
    List<PropertyModel> viewPropertiesByCategory(String categoryName);
    boolean isDeleteProperty(int propId);
    boolean updateProperty(PropertyModel model);
}

