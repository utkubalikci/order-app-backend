package com.pitech.order_app_backend.requests;

import lombok.Data;

@Data
public class UserCreateRequest {
    String fullName;
    String userName;
    String password;
    
    
	public UserCreateRequest(String fullName, String userName, String password) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
	}
	
	
	public UserCreateRequest() {
		super();
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
