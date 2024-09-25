package com.pitech.order_app_backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pitech.order_app_backend.entities.Cart;
import com.pitech.order_app_backend.entities.CartItem;
import com.pitech.order_app_backend.entities.Product;
import com.pitech.order_app_backend.entities.User;
import com.pitech.order_app_backend.repositories.ICartItemRepo;
import com.pitech.order_app_backend.repositories.ICartRepo;
import com.pitech.order_app_backend.requests.CartItemRequest;
import com.pitech.order_app_backend.responses.ProductInCartResponse;

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

	public Cart getCartByUserId(Long userId) {
		return cartRepo.findByUserId(userId).orElse(null);
	}

    public List<ProductInCartResponse> getProductsInCart(Long userId) {
        Cart cart = getCartByUserId(userId);
        List<ProductInCartResponse> products = new ArrayList<>();
        for (CartItem item : cart.getCartItems()) {
            // ProductInCartResponse newProduct = new ProductInCartResponse();
            // newProduct.setId(item.getProduct().getId());
            // newProduct.setProductName(item.getProduct().getName());
            // newProduct.setQuantity(item.getQuantity());
            // newProduct.setPrice(item.getProduct().getPrice());
            products.add(new ProductInCartResponse(item.getProduct().getId(), item.getProduct().getName(), item.getQuantity(), item.getProduct().getPrice()));
        }
        return products;
    }

	public ResponseEntity<Void> removeCartByUserId(Long userId) {
		Cart cartToDelete = cartRepo.findByUserId(userId).orElse(null);
		if (cartToDelete == null) {
			return ResponseEntity.notFound().build();
		}
		cartRepo.delete(cartToDelete);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Void> removeCart(Cart cart) {
		cartRepo.delete(cart);
		return ResponseEntity.ok().build();
	}

}
