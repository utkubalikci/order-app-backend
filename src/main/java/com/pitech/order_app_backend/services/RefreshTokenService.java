package com.pitech.order_app_backend.services;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

import com.pitech.order_app_backend.entities.RefreshToken;
import com.pitech.order_app_backend.entities.User;
import com.pitech.order_app_backend.repositories.IRefreshTokenRepo;

public class RefreshTokenService {
    @Value("${refresh.token.expires.in}")
	Long expireSeconds;
	
	private IRefreshTokenRepo refreshTokenRepo;

	public RefreshTokenService(IRefreshTokenRepo refreshTokenRepository) {
		this.refreshTokenRepo = refreshTokenRepository;
	}
	
	public String createRefreshToken(User user) {
		RefreshToken token = refreshTokenRepo.findByUserId(user.getId());
		if(token == null) {
			token =	new RefreshToken();
			token.setUser(user);
		}
		token.setToken(UUID.randomUUID().toString());
		token.setExpiryDate(Date.from(Instant.now().plusSeconds(expireSeconds)));
		refreshTokenRepo.save(token);
		return token.getToken();
	}
	
	public boolean isRefreshExpired(RefreshToken token) {
		return token.getExpiryDate().before(new Date());
	}

	public RefreshToken getByUser(Long userId) {
		return refreshTokenRepo.findByUserId(userId);	
	}
}
