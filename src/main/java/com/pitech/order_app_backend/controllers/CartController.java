package com.pitech.order_app_backend.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pitech.order_app_backend.entities.Cart;
import com.pitech.order_app_backend.requests.CartItemRequest;
import com.pitech.order_app_backend.responses.ProductInCartResponse;
import com.pitech.order_app_backend.responses.ProductResponse;
import com.pitech.order_app_backend.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        super();
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable Long userId) {
        System.out.println("getCart userId: " + userId);
        return cartService.getCartByUserId(userId);
    }

    @GetMapping("/products/{userId}")
    public List<ProductInCartResponse> getProductsInCart(@PathVariable Long userId) {
        return cartService.getProductsInCart(userId);
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
