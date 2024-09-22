package com.pitech.order_app_backend.responses;

import com.pitech.order_app_backend.entities.Category;

import lombok.Data;

@Data
public class CategoryResponse {
    private Long id;
    private String name;
    
    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
    
}
