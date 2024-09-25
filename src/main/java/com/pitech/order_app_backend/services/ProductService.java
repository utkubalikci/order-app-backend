package com.pitech.order_app_backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pitech.order_app_backend.entities.Category;
import com.pitech.order_app_backend.entities.Product;
import com.pitech.order_app_backend.repositories.IProductRepo;
import com.pitech.order_app_backend.requests.ProductCreateRequest;
import com.pitech.order_app_backend.responses.ProductResponse;

@Service
public class ProductService {

	private IProductRepo productRepo;
	private CategoryService categoryService;

    public ProductService(IProductRepo productRepo, CategoryService categoryService) {
		super();
		this.productRepo = productRepo;
		this.categoryService = categoryService;
	}

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

    public Product getProductById(Long productId) {
		return productRepo.findById(productId).orElse(null);
	}

	public Product addProduct(ProductCreateRequest productCreateRequest) {
		Category category = categoryService.getCategoryById(productCreateRequest.getCategoryId());
		Product newProduct = new Product();
		newProduct.setName(productCreateRequest.getName());
		newProduct.setPrice(productCreateRequest.getPrice());
		newProduct.setCategory(category);
		newProduct.setStock(productCreateRequest.getStock());
		newProduct.setDescription(productCreateRequest.getDescription());
		newProduct.setImageUrl(productCreateRequest.getImageUrl());
		return productRepo.save(newProduct);
	}

	public List<ProductResponse> getProductsByCategoryId(Long categoryId) {
		List<Product> products = productRepo.findByCategoryId(categoryId);
		List<ProductResponse> productResponses = new ArrayList<ProductResponse>();
		for (Product product : products ) {
			productResponses.add(new ProductResponse(product));
		}
		return productResponses;
	}
	
}
