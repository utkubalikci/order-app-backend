package com.pitech.order_app_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitech.order_app_backend.entities.User;

public interface IUserRepo extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    
}
