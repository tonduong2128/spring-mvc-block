package com.tonduong.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tonduong.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
}
