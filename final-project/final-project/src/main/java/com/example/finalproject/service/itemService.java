package com.example.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.dao.FoodOrderDao;
import com.example.finalproject.dao.itemDao;
import com.example.finalproject.dto.FoodOrder;
import com.example.finalproject.dto.item;

@Service
public class itemService {

	@Autowired
	itemDao iDao;
	@Autowired
	FoodOrderDao foodOrderDao;
	
	public item saveitem(item i, int id) {
		FoodOrder foodOrder=foodOrderDao.getFoodOrderById(id);
		i.setFoodOrder(foodOrder);
		return iDao.saveitem(i);
	}
	public item updateitem(item i, int id) {
	FoodOrder foodOrder=foodOrderDao.getFoodOrderById(id);
	i.setFoodOrder(foodOrder);
		return iDao.updateitem(i);
	}
	public List<item> getAllitem(){
		return iDao.getAllitem();
	}
	public item getitemById(int id) {
		return iDao.getitemById(id);
	}
	public String deleteitem(int id) {
		return iDao.deleteitem(id);
	}
}
