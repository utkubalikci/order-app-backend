package com.pitech.order_app_backend.services;

import org.springframework.stereotype.Service;

import com.pitech.order_app_backend.repositories.IUserRepo;

@Service
public class UserService {
    
    private IUserRepo userRepo;
    
    public UserService(IUserRepo userRepo) {
        super();
        this.userRepo = userRepo;
    }
}
