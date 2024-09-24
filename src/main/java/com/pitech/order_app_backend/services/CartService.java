package com.pitech.order_app_backend.services;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pitech.order_app_backend.entities.Cart;
import com.pitech.order_app_backend.entities.CartItem;
import com.pitech.order_app_backend.entities.Product;
import com.pitech.order_app_backend.entities.User;
import com.pitech.order_app_backend.repositories.ICartItemRepo;
import com.pitech.order_app_backend.repositories.ICartRepo;
import com.pitech.order_app_backend.requests.CartItemRequest;

@Service
public class CartService {
    private ICartRepo cartRepo;
    private ICartItemRepo cartItemRepo;
    private UserService userService;
    private ProductService productService;

    public CartService(ICartRepo cartRepo, UserService userService, ProductService productService,
            ICartItemRepo cartItemRepo) {
        super();
        this.cartItemRepo = cartItemRepo;
        this.cartRepo = cartRepo;
        this.userService = userService;
        this.productService = productService;
    }

    public ResponseEntity<Void> addToCart(CartItemRequest cartItemRequest) {
        User user = userService.getUserById(cartItemRequest.getUserId());
        Product product = productService.getProductById(cartItemRequest.getProductId());
        if (user == null || product == null) {
            return ResponseEntity.notFound().build();
        }
        Cart cart = cartRepo.findByUserId(cartItemRequest.getUserId()).orElse(null);
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.setCartItems(new ArrayList<CartItem>());
        }

        boolean itemExists = false;
        for (CartItem item : cart.getCartItems()) {
            if (item.getProduct().getId().equals(cartItemRequest.getProductId())) {
                item.setQuantity(item.getQuantity() + cartItemRequest.getQuantity());
                itemExists = true;
                break;
            }
        }
        if (!itemExists) {
            cart.getCartItems().add(new CartItem(cart, product, cartItemRequest.getQuantity()));
        }

        cartRepo.save(cart);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> removeFromCart(CartItemRequest cartItemRequest) {
        User user = userService.getUserById(cartItemRequest.getUserId());
        Product product = productService.getProductById(cartItemRequest.getProductId());
        if (user == null || product == null) {
            return ResponseEntity.notFound().build();
        }

        Cart cart = cartRepo.findByUserId(cartItemRequest.getUserId()).orElse(null);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }
        System.out.println("Service Delete");
        for (CartItem item : cart.getCartItems()) {
            if (item.getProduct().getId().equals(cartItemRequest.getProductId())) {
                cart.getCartItems().remove(item);
                cartItemRepo.delete(item);
                break;
            }
        }
        cartRepo.save(cart);
        return ResponseEntity.ok().build();
    }

}
