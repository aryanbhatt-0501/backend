package com.cl.foodapp.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.foodapp.entity.User;
import com.cl.foodapp.repository.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	UserRepository userRepository;
	public User saveAdmin(User user) {
		return userRepository.save(user);
	}
	public Optional<User> getby(int id) {
		return userRepository.findById(id);
	}
	public User delete(int id) {
		User user=getby(id).get();
		userRepository.delete(user);
		return user;
	}
	public User updatAdmin(User user,int id) {
			user.setId(id);
			return userRepository.save(user);
		}
	public List<User> getall(){
		return userRepository.findAll();
	}
	public String getRole(int id) {
		String admin=getby(id).get().getRole();
		return admin;
	}
	public User findbyEmailnPassword(User user) throws Exception {
		String email=user.getEmail();
		String password=user.getPassword();
		User obj=null;
		if(email!=null && password!=null) {
			obj=userRepository.findByEmailAndPassword(email, password);
		}
		if(obj==null) {
			throw new Exception("invalid");
		}
		return obj;
	}
	public User getUserById(int id) {
		Optional<User> found=userRepository.findById(id);
		if(found.isPresent()) {
			return found.get();
		}else {
			return null;
		}
	}
	
	
	
}
