package com.pitech.order_app_backend.responses;

import java.math.BigDecimal;

import com.pitech.order_app_backend.entities.Product;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
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
}
