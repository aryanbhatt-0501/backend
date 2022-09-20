package com.example.finalproject.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	@JsonManagedReference
	@OneToMany(mappedBy="menu",cascade = CascadeType.ALL)
	private List<FoodProduct> foodProduct;
	
	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private User user;
	
	public List<FoodProduct> getFoodProduct() {
		return foodProduct;
	}

	public void setFoodProduct(List<FoodProduct> foodProduct) {
		this.foodProduct = foodProduct;
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

}
