package com.pitech.order_app_backend.services;

import org.springframework.stereotype.Service;

import com.pitech.order_app_backend.repositories.ICategoryRepo;

@Service
public class CategoryService {

	private ICategoryRepo categoryRepo;

	public CategoryService(ICategoryRepo categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}
	
	
}
