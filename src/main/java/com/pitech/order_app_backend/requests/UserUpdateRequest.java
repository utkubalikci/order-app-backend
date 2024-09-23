package com.pitech.order_app_backend.requests;

public class UserUpdateRequest {
    String fullName;
    String userName;
    String password;
    
	public UserUpdateRequest(String fullName, String userName, String password) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
