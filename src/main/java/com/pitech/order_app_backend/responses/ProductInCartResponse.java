package com.pitech.order_app_backend.responses;

import java.math.BigDecimal;

public class ProductInCartResponse {
    private Long id;
    private String productName;
    private int quantity;
    private BigDecimal price;

    public ProductInCartResponse(Long id, String productName, int quantity, BigDecimal price) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductInCartResponse() {
    }

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    
}
