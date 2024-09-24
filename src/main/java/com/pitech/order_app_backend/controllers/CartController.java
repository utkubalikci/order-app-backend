package com.pitech.order_app_backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pitech.order_app_backend.requests.CartItemRequest;
import com.pitech.order_app_backend.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        super();
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addToCart(@RequestBody CartItemRequest cartItemRequest) {
        return cartService.addToCart(cartItemRequest);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeFromCart(@RequestBody CartItemRequest cartItemRequest) {
        return cartService.removeFromCart(cartItemRequest);
    }
}
