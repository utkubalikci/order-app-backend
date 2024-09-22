package com.pitech.order_app_backend.requests;

import lombok.Data;

@Data
public class UserUpdateRequest {
    String fullName;
    String userName;
    String password;
}
