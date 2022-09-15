package com.example.finalproject.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.finalproject.dto.Menu;

import com.example.finalproject.repository.MenuRepository;


@Repository
public class MenuDao {

	@Autowired
	MenuRepository menuRepository;
	
	public Menu saveMenu(Menu menu) {
		return menuRepository.save(menu);
	}
	public Menu updateMenu(Menu menu) {
		return menuRepository.save(menu);
	}
	
	public Menu getMenuById(int id) {
		Optional <Menu>found=menuRepository.findById(id);
		if(found.isPresent()) {
			return found.get();
		}else {
			return null;
		}
	}
	
}
