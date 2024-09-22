package com.pitech.order_app_backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pitech.order_app_backend.responses.ProductResponse;
import com.pitech.order_app_backend.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts().stream().map(p -> new ProductResponse(p)).toList();
    }

    @GetMapping("/{productId}")
    public ProductResponse getOneProduct(@PathVariable Long productId) {
        return new ProductResponse(productService.getProductById(productId));
    }
}
