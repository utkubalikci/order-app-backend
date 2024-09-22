package com.pitech.order_app_backend.responses;

import java.math.BigDecimal;

import com.pitech.order_app_backend.entities.OrderItem;

import lombok.Data;

@Data
public class OrderItemResponse {
    private Long id;
    private Long orderId;
    private Long productId;
    private int quantity;
    private BigDecimal price;

    public OrderItemResponse(OrderItem orderItem){
        this.id = orderItem.getId();
        this.orderId = orderItem.getOrder().getId();
        this.productId = orderItem.getProduct().getId();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
    }

    
    
}
