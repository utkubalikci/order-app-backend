package com.pitech.order_app_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitech.order_app_backend.entities.RefreshToken;

public interface IRefreshTokenRepo extends JpaRepository<RefreshToken, Long> {
    RefreshToken findByToken(String token);
    RefreshToken findByUserId(Long userId);
    
}
