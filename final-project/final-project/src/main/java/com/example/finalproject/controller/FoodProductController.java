package com.example.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalproject.dto.FoodProduct;
import com.example.finalproject.service.FoodProductService;

@RestController
public class FoodProductController {

	@Autowired
	FoodProductService foodProductService;
	
	@PostMapping("/productsave/{menuId}")
	public FoodProduct saveFoodProduct(@RequestBody FoodProduct foodProduct,@PathVariable int menuId) {
		return foodProductService.saveFoodProduct(foodProduct,menuId);
	}
	@PutMapping("/productupdate/{menuId}")
	public FoodProduct updateFoodProduct(@RequestBody FoodProduct foodProduct,@PathVariable int menuId) {
		return foodProductService.updateFoodProduct(foodProduct, menuId);
	}
	@GetMapping("/allproduct")
	public List<FoodProduct> getAllFoodProducts(){
		return foodProductService.getAllFoodProducts();
	}
	@GetMapping("/allproduct/{fpId}")
	public FoodProduct getFoodProductById(@PathVariable int fpId) {
		return foodProductService.getFoodProductById(fpId);
	}
	@DeleteMapping("/allproduct/{fpId}")
	public String deleteFoodProduct(@PathVariable int fpId) {
		return foodProductService.deleteFoodProduct(fpId);
	}
}
