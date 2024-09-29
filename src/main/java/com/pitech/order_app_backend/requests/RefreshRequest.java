package com.pitech.order_app_backend.requests;


public class RefreshRequest {

	Long userId;
	String refreshToken;
		
	public RefreshRequest(Long userId, String refreshToken) {
		super();
		this.userId = userId;
		this.refreshToken = refreshToken;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	
}