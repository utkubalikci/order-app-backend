package com.pitech.order_app_backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pitech.order_app_backend.entities.Category;
import com.pitech.order_app_backend.requests.CategoryCreateRequest;
import com.pitech.order_app_backend.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@GetMapping("/all")
	public List<Category> getAllCategories(){
		return categoryService.getAllCategories();
	}
	
	@PostMapping("/add")
	public Category addCategory(@RequestBody CategoryCreateRequest categoryReq) {
		return categoryService.addCategory(categoryReq);
	}
	
	@PutMapping("/edit")
	public Category editCategory(@RequestBody Category category) {
		return categoryService.editCategory(category);
	}
}
