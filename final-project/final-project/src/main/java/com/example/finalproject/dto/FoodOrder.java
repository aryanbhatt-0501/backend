package com.example.finalproject.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class FoodOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String status;
	private double totalPrice;
	private String orderCT;
	private String orderDT;
	private String custName;
	private long contactNo;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn
	private User user;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy="foodOrder", cascade = CascadeType.ALL)
	List<item> items;
	
	public List<item> getItems() {
		return items;
	}
	public void setItems(List<item> items) {
		this.items = items;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderCT() {
		return orderCT;
	}
	public void setOrderCT(String orderCT) {
		this.orderCT = orderCT;
	}
	public String getOrderDT() {
		return orderDT;
	}
	public void setOrderDT(String orderDT) {
		this.orderDT = orderDT;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	
}
