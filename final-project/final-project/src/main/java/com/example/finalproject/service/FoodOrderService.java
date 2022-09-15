package com.example.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.dao.FoodOrderDao;
import com.example.finalproject.dao.UserDao;
import com.example.finalproject.dto.FoodOrder;
import com.example.finalproject.dto.User;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDao foodOrderDao;
	@Autowired
	UserDao userDao;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder,int id) {
		User user=userDao.getUserById(id);
		foodOrder.setUser(user);
		return foodOrderDao.saveFoodOrder(foodOrder);
	}
	public FoodOrder updateFoodOrder(FoodOrder foodOrder, int id) {
		User user=userDao.getUserById(id);
		foodOrder.setUser(user);
		return foodOrderDao.updateFoodOrder(foodOrder);
	}
	public List<FoodOrder> getAllFoodOrders(){
		return foodOrderDao.getAllFoodOrder();
	}
	public FoodOrder getFoodOrderById(int id) {
		return foodOrderDao.getFoodOrderById(id);
	}
	public String deleteFoodOrder(int id) {
		return foodOrderDao.deleteFoodProduct(id);
	}
	
}