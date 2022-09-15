package com.example.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalproject.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmailAndPassword(String mail, String password) ;
		
	
}
