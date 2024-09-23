package com.pitech.order_app_backend.responses;

import java.math.BigDecimal;

import com.pitech.order_app_backend.entities.Product;

import jakarta.persistence.Lob;

public class ProductResponse {

    private Long id;

    private String name;

    private int stock;

    private Long categoryId;

    private BigDecimal price;
    
    @Lob
    private String description;
    
    private String imageUrl;

    public ProductResponse(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.stock = product.getStock();
        this.categoryId = product.getCategory().getId();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.imageUrl = product.getImageUrl();
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
}
