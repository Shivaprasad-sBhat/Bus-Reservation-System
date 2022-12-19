package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.User;
import com.masai.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService uService;
	
	@CrossOrigin
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser( @Valid @RequestBody User user) {
		
	     User us = uService.createUser(user);
	     
	     return new ResponseEntity<User>(us, HttpStatus.ACCEPTED);
	     
	}
	
	
	@CrossOrigin
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user ){
		
		User us = uService.updateUser(user);
		
		
		return new ResponseEntity<User>(us, HttpStatus.ACCEPTED);
		
	}
	
	
	@CrossOrigin
	@DeleteMapping("/deleteUser")
	public ResponseEntity<User> deleteUser(@RequestParam("id") int userId){
		
		User us = uService.deleteUser(userId);
		
		
		return new ResponseEntity<User>(us, HttpStatus.ACCEPTED);
		
	}
	
	@CrossOrigin
	@GetMapping("/getUserByid")
	public ResponseEntity<User> getUserByid(@RequestParam("id") int userId){		
		User us = uService.viewUser(userId);
		
		
		return new ResponseEntity<User>(us, HttpStatus.ACCEPTED);
		
	}
	
	
	@CrossOrigin
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> us = uService.viewAllUser();
		
		
		return new ResponseEntity<List<User>>(us, HttpStatus.ACCEPTED);
		
	}
	
	
}
