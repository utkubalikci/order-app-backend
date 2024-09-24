package com.pitech.order_app_backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pitech.order_app_backend.entities.Category;
import com.pitech.order_app_backend.repositories.ICategoryRepo;

@Service
public class CategoryService {

	private ICategoryRepo categoryRepo;

	public CategoryService(ICategoryRepo categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}

	public Category getCategoryById(Long categoryId) {
		return categoryRepo.findById(categoryId).orElse(null);
	}

	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}
	
	
}
