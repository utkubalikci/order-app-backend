package com.pitech.order_app_backend.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.pitech.order_app_backend.entities.Order;
import com.pitech.order_app_backend.entities.enums.OrderStatus;

public class OrderResponse {
    Long id;
    Long userId;
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
        this.userId = order.getUser().getId();
    }


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<OrderItemResponse> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(List<OrderItemResponse> orderItems) {
		this.orderItems = orderItems;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}
    
}
