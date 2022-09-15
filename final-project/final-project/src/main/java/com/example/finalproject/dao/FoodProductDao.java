package com.example.finalproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.finalproject.dto.FoodProduct;
import com.example.finalproject.repository.FoodProductRepository;

@Repository
public class FoodProductDao {

	@Autowired
	FoodProductRepository foodProductRepository;
	
	public FoodProduct saveFoodProduct(FoodProduct foodProduct) {
		return foodProductRepository.save(foodProduct);
	}
	public FoodProduct updateFoodProduct(FoodProduct foodProduct) {
		return foodProductRepository.save(foodProduct);
	}
	public List<FoodProduct> getAllFoodProduct(){
		return foodProductRepository.findAll();
	}
	public FoodProduct getFoodProductById(int id) {
		Optional<FoodProduct> found=foodProductRepository.findById(id);
		if(found.isPresent()) {
			return found.get();			
		}else {
			return null;
		}
	}
	public String deleteFoodProduct(int id) {
		FoodProduct foodProduct=getFoodProductById(id);
		if(foodProduct!=null) {
			foodProductRepository.delete(foodProduct);
			return foodProduct.getName()+" food product is deleted";
		}else {
			return "no food product found";
		}
	}
}
