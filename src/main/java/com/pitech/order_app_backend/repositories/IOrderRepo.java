package com.pitech.order_app_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pitech.order_app_backend.entities.Order;

public interface IOrderRepo extends JpaRepository<Order, Long>{

}
