package com.pitech.order_app_backend.responses;

import com.pitech.order_app_backend.entities.Category;


public class CategoryResponse {
    private Long id;
    private String name;
    
    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
