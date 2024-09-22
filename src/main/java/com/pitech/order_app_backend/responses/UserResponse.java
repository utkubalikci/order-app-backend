package com.pitech.order_app_backend.responses;

import com.pitech.order_app_backend.entities.User;

import lombok.Data;

@Data
public class UserResponse {
    Long id;
    String fullName;
    String userName;

    public UserResponse(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.userName = user.getUserName();
    }
}
