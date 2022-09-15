package com.example.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalproject.dto.Menu;
import com.example.finalproject.dto.User;
import com.example.finalproject.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	MenuService menuService;
	
	@PostMapping("/savemenu/{userId}")
	public Menu saveMenu(@RequestBody Menu menu, @PathVariable int userId) {
		return menuService.saveMenu(menu, userId);
	}
	@PutMapping("/updatemenu")
	public Menu updateMenu(@RequestBody Menu menu) {
		return menuService.updateMenu(menu);
	}
}
