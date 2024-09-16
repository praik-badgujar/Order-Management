package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "customer_order")
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@ManyToOne
	private Customer customer;
	 @ManyToMany
	    @JoinTable(
	        name = "order_grocery_item",
	        joinColumns = @JoinColumn(name = "order_id"),
	        inverseJoinColumns = @JoinColumn(name = "grocery_item_id")
	    )
	private Set<GroceryItem> grocery;
	private LocalDate orderDate;
	private Double totalPrice;
	public Order() {
		
	}
	public Order(Long id, Customer customer, Set<GroceryItem> grocery, LocalDate orderDate, Double totalPrice) {
		super();
		this.id = id;
		this.customer = customer;
		this.grocery = grocery;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<GroceryItem> getGrocery() {
		return grocery;
	}
	public void setGrocery(Set<GroceryItem> grocery) {
		this.grocery = grocery;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", grocery=" + grocery + ", orderDate=" + orderDate
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	
	

}
