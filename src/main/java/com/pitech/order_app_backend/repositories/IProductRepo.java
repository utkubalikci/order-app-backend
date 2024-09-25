package com.pitech.order_app_backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitech.order_app_backend.entities.Product;

public interface IProductRepo extends JpaRepository<Product, Long>{

	List<Product> findByCategoryId(Long categoryId);

}
