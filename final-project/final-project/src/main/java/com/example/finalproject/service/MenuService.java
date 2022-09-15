package com.example.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.dao.MenuDao;
import com.example.finalproject.dao.UserDao;
import com.example.finalproject.dto.Menu;
import com.example.finalproject.dto.User;

@Service
public class MenuService {

	@Autowired
	MenuDao menuDao;
	@Autowired
	UserDao userDao;
	
	public Menu saveMenu(Menu menu, int id) {
		User user=userDao.getUserById(id);
		menu.setUser(user);
		return menuDao.saveMenu(menu);
	}
	public Menu updateMenu(Menu menu) {
		return menuDao.updateMenu(menu);
	}
}
