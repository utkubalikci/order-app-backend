package com.pitech.order_app_backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitech.order_app_backend.entities.Cart;

public interface ICartRepo extends JpaRepository<Cart, Long> {

	Optional<Cart> findByUserId(Long userId);
    
}
