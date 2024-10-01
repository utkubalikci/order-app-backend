package com.pitech.order_app_backend.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pitech.order_app_backend.entities.Cart;
import com.pitech.order_app_backend.responses.OrderResponse;
import com.pitech.order_app_backend.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;
	
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@GetMapping("/user/{userId}")
	public List<OrderResponse> getOrdersByUserId(@PathVariable Long userId){
		return orderService.getOrdersByUserId(userId);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id,@AuthenticationPrincipal UserDetails userDetails) {
	    if (orderService.validateOrderRequest(id, userDetails.getUsername())) {
	        OrderResponse orderResponse = orderService.getOrderById(id);
	        return ResponseEntity.ok(orderResponse);
	    } else {
	        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	    }
	}

	@PostMapping("/create")
	public ResponseEntity<Void> createOrder(@RequestBody Cart cart){
		return orderService.createOrder(cart);
	}
	
	@PostMapping("/createByUserId/{userId}")
	public ResponseEntity<Void> createOrderByUserId(@PathVariable Long userId){
		return orderService.createOrderByUserId(userId);
	}
	
	@PutMapping("/confirm/{orderId}")
	public ResponseEntity<Void> confirmOrder(@PathVariable Long orderId){
		return orderService.confirmOrder(orderId);
	}

}
