package com.pitech.order_app_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitech.order_app_backend.entities.Category;

public interface ICategoryRepo extends JpaRepository<Category, Long> {

}
