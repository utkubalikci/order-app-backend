package com.pitech.order_app_backend.requests;

import java.math.BigDecimal;

import jakarta.persistence.Lob;

public class ProductCreateRequest {
    Long id;
    
    String name;

    int stock;

    Long categoryId;

    BigDecimal price;

    @Lob
    String description;
    
    String imageUrl;
    
	public ProductCreateRequest(String name, int stock, Long categoryId, BigDecimal price, String description,
			String imageUrl) {
		this.name = name;
		this.stock = stock;
		this.categoryId = categoryId;
		this.price = price;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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

	public Long getId() {
		return id;
	}

}
