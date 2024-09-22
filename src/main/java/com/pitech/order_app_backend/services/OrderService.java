package com.pitech.order_app_backend.services;

import org.springframework.stereotype.Service;

import com.pitech.order_app_backend.repositories.IOrderRepo;

@Service
public class OrderService {

	private IOrderRepo orderRepo;

	public OrderService(IOrderRepo orderRepo) {
		super();
		this.orderRepo = orderRepo;
	}
	
}
