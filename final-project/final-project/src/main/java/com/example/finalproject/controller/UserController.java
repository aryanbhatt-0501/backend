package com.cl.foodapp.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cl.foodapp.entity.User;
import com.cl.foodapp.service.UserService;
import com.cl.foodapp.responseStructure.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<User>> saveAdmin(@RequestBody User user) {
		return userService.saveAdmin(user);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<User>> getby(@PathVariable int id) {
		return userService.getby(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<User>> delete(@PathVariable int id) {
		return userService.delete(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<User>> updateadmin(@RequestBody User user,@PathVariable int id) {
		return userService.updateadmin(user, id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/user")
	public ResponseEntity<ResponseStructure<List<User>>> getall(){
		return userService.getall();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/getrole/{id}")
	public String get(@PathVariable int id){
		return userService.getRole(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/getby")
	public User get(@RequestBody User user) throws Exception {
		return userService.findbyEmailnPassword(user);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public User checkmailandpassword(@RequestBody User user) throws Exception{
        
        return userService.checkmailandpassword(user);
    }
}


