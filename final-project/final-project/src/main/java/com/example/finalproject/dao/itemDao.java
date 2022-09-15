package com.example.finalproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.finalproject.dto.item;
import com.example.finalproject.repository.itemRepository;

@Repository
public class itemDao {

	@Autowired
	itemRepository iRepo;
	
	public item saveitem(item i) {
		return iRepo.save(i);
	}
	public item updateitem(item i) {
		return iRepo.save(i);
	}
	public List<item> getAllitem(){
		return iRepo.findAll();
	}
	public item getitemById(int id) {
		Optional<item> found=iRepo.findById(id);
		if(found.isPresent()) {
			return found.get();
		}else {
			return null;
		}
	}
	public String deleteitem(int id) {
		item i=getitemById(id);
		if(i!=null) {
			iRepo.delete(i);
			return i.getName()+" item is deleted";
		}else {
			return "no item found";
		}
	}
}
