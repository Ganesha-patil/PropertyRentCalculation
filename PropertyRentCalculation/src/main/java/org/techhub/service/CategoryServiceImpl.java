package org.techhub.service;

import java.util.List;


import org.techhub.model.PropCategoryModel;
import org.techhub.repository.*;

public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository catRepo = new CategoryRepositoryImpl();
	@Override
	public boolean isSaveCategory(PropCategoryModel category) {
		// TODO Auto-generated method stub
		return catRepo.isSaveCategory(category);
	}

	@Override
	public List<PropCategoryModel> viewAllCategories() {
		// TODO Auto-generated method stub
		return catRepo.viewAllCategories();
	}

	@Override
	public PropCategoryModel updateCategory(PropCategoryModel model) {
		// TODO Auto-generated method stub
		return catRepo.updateCategory(model);
	}

	@Override
	public boolean isDeleteCategory(int cId) {
		// TODO Auto-generated method stub
		return catRepo.isDeleteCategory( cId);
	}

}
