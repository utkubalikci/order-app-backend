package com.pitech.order_app_backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pitech.order_app_backend.entities.User;
import com.pitech.order_app_backend.repositories.IUserRepo;

@Service
public class UserService {
    
    private IUserRepo userRepo;
    
    public UserService(IUserRepo userRepo) {
        super();
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User saveUser(User newUser) {
        return userRepo.save(newUser);
    }

    public User getUserById(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }

}
