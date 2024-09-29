package com.pitech.order_app_backend.requests;

import jakarta.persistence.Lob;

public class CategoryCreateRequest {

	String name;
	
	@Lob
	String description;
	
	String imageUrl;

	public CategoryCreateRequest(String name, String description, String imageUrl) {
		super();
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public CategoryCreateRequest() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
