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
import com.example.finalproject.dto.FoodOrder;
import com.example.finalproject.service.FoodOrderService;

@RestController
public class FoodOrderController {

	@Autowired
	FoodOrderService foodOrderService;
	
	@PostMapping("/savefood/{userId}")
	public FoodOrder saveFoodOrder(@RequestBody FoodOrder foodOrder, @PathVariable int userId) {
		return foodOrderService.saveFoodOrder(foodOrder, userId);
	}
	@PutMapping("/updatefood/{userId}")
	public FoodOrder updateFoodOrder(@RequestBody FoodOrder foodOrder, @PathVariable int userId) {
		return foodOrderService.updateFoodOrder(foodOrder,userId);
	}
	@GetMapping("/allfood")
	public List<FoodOrder> getAllFoodOrder() {
		return foodOrderService.getAllFoodOrders();
	}
	@GetMapping("/allfood/{foodid}")
	public FoodOrder getFoodOrderById(@PathVariable int foodid) {
		return foodOrderService.getFoodOrderById(foodid);
	}
	@DeleteMapping("/allfood/{foodid}")
	public String deleteFoodOrder(@PathVariable int foodid) {
		return foodOrderService.deleteFoodOrder(foodid);
	}
}
