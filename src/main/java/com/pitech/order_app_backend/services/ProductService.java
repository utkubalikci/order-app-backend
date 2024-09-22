package com.pitech.order_app_backend.services;

import org.springframework.stereotype.Service;

import com.pitech.order_app_backend.repositories.IProductRepo;

@Service
public class ProductService {

	private IProductRepo productRepo;

	public ProductService(IProductRepo productRepo) {
		super();
		this.productRepo = productRepo;
	}
	
	
}
