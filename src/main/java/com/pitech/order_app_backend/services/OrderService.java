package com.pitech.order_app_backend.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.pitech.order_app_backend.entities.Cart;
import com.pitech.order_app_backend.entities.CartItem;
import com.pitech.order_app_backend.entities.Order;
import com.pitech.order_app_backend.entities.OrderItem;
import com.pitech.order_app_backend.entities.enums.OrderStatus;
import com.pitech.order_app_backend.repositories.IOrderItemRepo;
import com.pitech.order_app_backend.repositories.IOrderRepo;
import com.pitech.order_app_backend.responses.OrderResponse;

@Service
public class OrderService {

	private IOrderRepo orderRepo;
	private CartService cartService;
	private IOrderItemRepo orderItemRepo;

	public OrderService(IOrderRepo orderRepo, CartService cartService, IOrderItemRepo orderItemRepo) {
		super();
		this.orderItemRepo = orderItemRepo;
		this.orderRepo = orderRepo;
		this.cartService = cartService;
	}

	public ResponseEntity<Void> createOrder(Cart cart) {
		Order order = new Order();
		BigDecimal total = BigDecimal.ZERO;
		order.setOrderDate(LocalDateTime.now());
		order.setStatus(OrderStatus.BEKLIYOR);
		order.setUser(cart.getUser());
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItemToSave = new OrderItem(order, cartItem.getProduct(), cartItem.getQuantity(), cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())  ));
			total = total.add(orderItemToSave.getPrice());
			orderItems.add(orderItemToSave);
		}
		order.setPrice(total);
		order.setOrderItems(orderItems);
		orderRepo.save(order);
		cartService.removeCart(cart);
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<Void> createOrderByUserId (Long userId){
		return createOrder(cartService.getCartByUserId(userId));
	}

	public List<OrderResponse> getOrdersByUserId(Long userId) {
		List<Order> orders = orderRepo.findByUserId(userId);
		List<OrderResponse> orderResponses = new ArrayList<OrderResponse>();
		for (Order order : orders) {
//			OrderResponse orderToSave = new OrderResponse(order);
			orderResponses.add(new OrderResponse(order));
		}
		return orderResponses;
	}

	public ResponseEntity<Void> confirmOrder(Long orderId) {
		Order order = orderRepo.findById(orderId).orElse(null);
		order.setStatus(OrderStatus.ONAYLANDI);
		orderRepo.save(order);
		return ResponseEntity.ok().build();
	}
	
}
