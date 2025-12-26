package org.techhub.repository;

import java.util.List;
import org.techhub.model.PropertyModel;

public interface PropertyRepository {
    boolean isSaveProperty(PropertyModel model);
    List<PropertyModel> viewPropertiesByCity(String cityName);
    List<PropertyModel> viewPropertiesByLocation(String locationName);
    List<PropertyModel> viewPropertiesByCategory(String categoryName);
    boolean isDeleteProperty(int propId);
    boolean updateProperty(PropertyModel model);
}
