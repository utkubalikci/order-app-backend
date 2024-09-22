package com.pitech.order_app_backend.requests;

public class UserRequest {
	String userName;
    String password;
    
	public UserRequest() {
		super();
	}
	
	public UserRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
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
