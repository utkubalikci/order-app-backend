package com.pitech.order_app_backend.entities;

import com.pitech.order_app_backend.entities.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    String fullName;

    String userName;

    String password;

    UserRole role;
}
