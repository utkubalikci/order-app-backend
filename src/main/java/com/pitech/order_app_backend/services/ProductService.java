package com.pitech.order_app_backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pitech.order_app_backend.entities.Category;
import com.pitech.order_app_backend.entities.Product;
import com.pitech.order_app_backend.repositories.IProductRepo;
import com.pitech.order_app_backend.requests.ProductCreateRequest;
import com.pitech.order_app_backend.requests.ProductUpdateRequest;
import com.pitech.order_app_backend.responses.ProductResponse;

import jakarta.persistence.EntityNotFoundException;

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
		if (productCreateRequest == null || productCreateRequest.getCategoryId() == null || productCreateRequest.getName() == null || productCreateRequest.getPrice() == null  || productCreateRequest.getDescription() == null || productCreateRequest.getImageUrl() == null) {
			return null;
		}
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

	public ProductResponse updateProduct(ProductUpdateRequest productReq) {
		Product product = productRepo.findById(productReq.getId()).orElseThrow(() -> new EntityNotFoundException("Product not found"));
		product.setName(productReq.getName());
        product.setStock(productReq.getStock());
        product.setPrice(productReq.getPrice());
        product.setDescription(productReq.getDescription());
        product.setImageUrl(productReq.getImageUrl());
        productRepo.save(product);
		return new ProductResponse(product);
	}
	
}
