package com.pitech.order_app_backend.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pitech.order_app_backend.entities.User;
import com.pitech.order_app_backend.repositories.IUserRepo;
import com.pitech.order_app_backend.security.JwtUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private IUserRepo userRepo;

    public UserDetailsServiceImpl(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);    
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Long id) {
        User user = userRepo.findById(id).get();
        return JwtUserDetails.create(user);
    }
    
    
}
