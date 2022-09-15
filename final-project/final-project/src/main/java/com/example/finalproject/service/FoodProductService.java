package com.example.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.dao.FoodProductDao;
import com.example.finalproject.dao.MenuDao;
import com.example.finalproject.dto.FoodProduct;
import com.example.finalproject.dto.Menu;
import com.example.finalproject.dto.User;

@Service
public class FoodProductService {

	@Autowired
	FoodProductDao foodProductDao;
	@Autowired
	MenuDao menuDao;
	
	public FoodProduct saveFoodProduct(FoodProduct foodProduct, int id) {
		Menu menu=menuDao.getMenuById(id);
		foodProduct.setMenu(menu);
		return foodProductDao.saveFoodProduct(foodProduct);
	}
	public FoodProduct updateFoodProduct(FoodProduct foodProduct, int id) {
		Menu menu=menuDao.getMenuById(id);
		foodProduct.setMenu(menu);
		return foodProductDao.updateFoodProduct(foodProduct);
	}
	public List<FoodProduct> getAllFoodProducts(){
		return foodProductDao.getAllFoodProduct();
	}
	public FoodProduct getFoodProductById(int id) {
		return foodProductDao.getFoodProductById(id);
	}
	public String deleteFoodProduct(int id) {
		return foodProductDao.deleteFoodProduct(id);
	}
}
