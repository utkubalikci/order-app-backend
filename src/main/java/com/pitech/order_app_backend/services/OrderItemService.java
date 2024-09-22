package com.pitech.order_app_backend.services;

import org.springframework.stereotype.Service;

import com.pitech.order_app_backend.repositories.IOrderItemRepo;

@Service
public class OrderItemService {

	private IOrderItemRepo orderItemRepo;

	public OrderItemService(IOrderItemRepo orderItemRepo) {
		super();
		this.orderItemRepo = orderItemRepo;
	}
	
	
}
