package com.pitech.order_app_backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pitech.order_app_backend.entities.User;
import com.pitech.order_app_backend.entities.enums.UserRole;
import com.pitech.order_app_backend.repositories.IUserRepo;
import com.pitech.order_app_backend.requests.UserCreateRequest;

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

    public User saveUser(UserCreateRequest newUser) {
        User user = new User();
        user.setFullName(newUser.getFullName());
        user.setUserName(newUser.getUserName());
        user.setPassword(newUser.getPassword());
        user.setRole(UserRole.CUSTOMER);
        return userRepo.save(user);
    }

    public User getUserById(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }

	public User getOneUserByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}

	public void saveOneUser(User user) {
		userRepo.save(user);
	}

}
