package org.techhub.repository;

import java.util.List;

import org.techhub.model.*;

public interface CategoryRepository {

	public boolean isSaveCategory(PropCategoryModel category);
	public List<PropCategoryModel> viewAllCategories();
	public PropCategoryModel updateCategory(PropCategoryModel model);
	public boolean isDeleteCategory(int cId);
}
