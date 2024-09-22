package com.pitech.order_app_backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pitech.order_app_backend.entities.Product;
import com.pitech.order_app_backend.repositories.IProductRepo;

@Service
public class ProductService {

	private IProductRepo productRepo;

	public ProductService(IProductRepo productRepo) {
		super();
		this.productRepo = productRepo;
	}

    public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

    public Product getProductById(Long productId) {
		return productRepo.findById(productId).orElse(null);
	}
	
}
