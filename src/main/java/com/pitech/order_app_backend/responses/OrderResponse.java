package com.pitech.order_app_backend.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.pitech.order_app_backend.entities.Order;
import com.pitech.order_app_backend.entities.enums.OrderStatus;

import lombok.Data;

@Data
public class OrderResponse {
    Long id;
    List<OrderItemResponse> orderItems;
    OrderStatus status;
    LocalDateTime orderDate;
    BigDecimal price;


    public OrderResponse(Order order){
        this.id = order.getId();
        this.orderItems = order.getOrderItems().stream().map(OrderItemResponse::new).collect(Collectors.toList());
        this.status = order.getStatus();
        this.orderDate = order.getOrderDate();
        this.price = order.getPrice();
    }
    
}
