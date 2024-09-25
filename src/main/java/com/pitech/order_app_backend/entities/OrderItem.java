package com.pitech.order_app_backend.entities;

import java.math.BigDecimal;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="order_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
    private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Product product;
	
	private int quantity;
    
    private BigDecimal price;

	public OrderItem() {
		super();
	}

	public OrderItem(Order order, Product product, int quantity, BigDecimal price) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}
	
	
}
