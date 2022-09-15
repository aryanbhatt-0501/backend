package com.example.finalproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.finalproject.dto.User;
import com.example.finalproject.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	public User getUserById(int id) {
		Optional<User> found=userRepository.findById(id);
		if(found.isPresent()) {
			return found.get();
		}else {
			return null;
		}
	}
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	public String deleteUser(int id) {
		User user=getUserById(id);
		if(user!=null) {
			userRepository.delete(user);
			return user.getName()+" user is deleted";
		}else {
			return "no user found";
		}
	}
	
	
}
