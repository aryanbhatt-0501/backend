package com.cl.foodapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cl.foodapp.Exception.IdNotFound;
import com.cl.foodapp.dao.UserDao;
import com.cl.foodapp.entity.User;
import com.cl.foodapp.repository.UserRepository;
import com.cl.foodapp.responseStructure.ResponseStructure;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserRepository userRepository;
	
	
	public ResponseEntity<ResponseStructure<User>> saveAdmin(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("user has been Saved");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setT(userDao.saveAdmin(user));
		return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.CREATED);}

	public ResponseEntity<ResponseStructure<User>> updateadmin(User user, int id) {
		Optional<User> optional = userDao.getby(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (optional.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			responseStructure.setT(null);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("user got updated");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(userDao.updatAdmin(user, id));
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);}}
	public ResponseEntity<ResponseStructure<User>> getby(int id) {
		Optional<User> optional = userDao.getby(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (optional.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("user has been found");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);}}
	public ResponseEntity<ResponseStructure<User>> delete(int id) {
		Optional<User> optional = userDao.getby(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (optional.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("admin has been deleted");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(userDao.delete(id));
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);}}
	
	public ResponseEntity<ResponseStructure<List<User>>> getall(){
		ResponseStructure<List<User>> responseStructure = new ResponseStructure<List<User>>();
		responseStructure.setMessage("all user has been found");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setT(userDao.getall());
	    return new  ResponseEntity<ResponseStructure<List<User>>>(responseStructure,HttpStatus.OK);}
    public String getRole(int id) {
	    Optional<User> optional=userDao.getby(id);
	    if(optional.isEmpty()) {
		   throw new IdNotFound();
	    }
	    else {
		   return optional.get().getRole();
	    }}


    public User findbyEmailnPassword(User user) throws Exception {

    	return userDao.findbyEmailnPassword(user);}
    
	//public User get(@PathVariable String email,@PathVariable String password) throws Exception {
		//return userService.checkmailandpassword(email,password);
	//}	
    

    
    public User checkmailandpassword(User user) throws Exception {
    	
       	String usertemp=user.getEmail();
    	String userpass=user.getPassword();
    	System.out.println(usertemp);
    	System.out.println(userpass);
    	User user1= userRepository.findByEmail(usertemp);
		//user ID
		//we have to get the role
		String role2=user1.getRole();
		System.out.println(role2);
		System.out.println(role2.getClass().getSimpleName());
		
    	System.out.println(user1.getEmail());
    	System.out.println(user1.getPassword());
    	
    	String s2="Manager";

    	
    	
    	System.out.println(role2);
		if (role2.equalsIgnoreCase(s2)) {
			System.out.println("hi");

	    	System.out.println(user1.getEmail());
	    	System.out.println(user1.getPassword());
			
			if (usertemp.equalsIgnoreCase(user1.getEmail()) && userpass.equalsIgnoreCase(user1.getPassword())) {
				//this means that, 
				return user1;
			}
			else {
				
				throw new Exception("Wrong Credentials");	
			}
			
		}else {
			System.out.println("hi");
			System.out.println(role2);
			throw new Exception("Staff Do not have Access");
		}
    	
    }
    
}
