package com.pitech.order_app_backend.requests;

import java.math.BigDecimal;

import jakarta.persistence.Lob;

public class ProductUpdateRequest {
    String name;

    int stock;

    Long categoryId;

    BigDecimal price;

    @Lob
    String description;
    
    String imageUrl;
    
}
