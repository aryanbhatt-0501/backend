package com.example.finalproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.finalproject.dto.FoodOrder;
import com.example.finalproject.dto.Menu;
import com.example.finalproject.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {

	
	@Autowired
	FoodOrderRepository foodOrderRepository;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder){
		return foodOrderRepository.save(foodOrder);
	}
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}
	public FoodOrder getFoodOrderById(int id) {
		Optional <FoodOrder>found=foodOrderRepository.findById(id);
		if(found.isPresent()) {
			return found.get();
		}else {
			return null;
		}
	}
	public List<FoodOrder> getAllFoodOrder(){
		return foodOrderRepository.findAll();
	}
	public String deleteFoodProduct(int id) {
		FoodOrder foodOrder=getFoodOrderById(id);
		if(foodOrder!=null) {
			foodOrderRepository.delete(foodOrder);
			return foodOrder.getCustName()+" Food order is deleted";
		}else {
			return "no order found";
		}
	}
	
	
	
}
