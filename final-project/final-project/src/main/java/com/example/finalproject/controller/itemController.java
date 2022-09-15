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

import com.example.finalproject.dto.item;
import com.example.finalproject.service.itemService;

@RestController
public class itemController {

	@Autowired
	itemService iService;
	
	@PostMapping("/itemsave/{foodOrderId}")
	public item saveitem(@RequestBody item i, @PathVariable int foodOrderId) {
		return iService.saveitem(i, foodOrderId);
	}
	@PutMapping("/itemupdate/{foodOrderId}")
	public item updateitem(@RequestBody item i, @PathVariable int  foodOrderId) {
		return iService.updateitem(i, foodOrderId);
	}
	@GetMapping("/allitems")
	public List<item> getAllitem(){
		return iService.getAllitem();
	}
	@GetMapping("/allitems/{itemid}")
	public item getitemById(@PathVariable int itemid) {
		return iService.getitemById(itemid);
	}
	@DeleteMapping("/deleteitem/{itemid}")
	public String deleteitem(@PathVariable int itemid) {
		return iService.deleteitem(itemid);
	}
}
