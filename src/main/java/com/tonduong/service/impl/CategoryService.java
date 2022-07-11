package com.tonduong.service.impl;

import java.util.List;

import com.tonduong.dao.ICategoryDAO;
import com.tonduong.model.CategoryModel;
import com.tonduong.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	private ICategoryDAO iCategoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return iCategoryDao.findAll();
	}
}
