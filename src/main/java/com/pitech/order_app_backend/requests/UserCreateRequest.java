package com.pitech.order_app_backend.requests;

import com.pitech.order_app_backend.entities.enums.UserRole;

import lombok.Data;

@Data
public class UserCreateRequest {
    String fullName;
    String userName;
    String password;
    UserRole role;
}
