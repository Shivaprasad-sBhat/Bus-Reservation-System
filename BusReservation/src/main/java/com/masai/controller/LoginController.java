package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Admin;
import com.masai.model.LoginDto;
import com.masai.model.User;
import com.masai.service.LoginService;



@RestController
public class LoginController {

	@Autowired
	private LoginService lService;
	
	
	@CrossOrigin
	@PostMapping("/userlogin")
	public ResponseEntity<User> loginUser(@RequestBody LoginDto credential) {
		
		System.out.println(credential);
		
		User res = lService.loginUser(credential);
						
			
		return new ResponseEntity<User>(res, HttpStatus.ACCEPTED);
			
		}
	
	
	@PostMapping("/userlogout")
	@CrossOrigin
	public ResponseEntity<String> logoutuser(@RequestParam("key") String key) {
		
		
		String res = lService.logoutUser(key);
						
			
		return new ResponseEntity<String>(res, HttpStatus.ACCEPTED);
			
		}
	
	
	
	/**************************************************************************************/
	
	
	@CrossOrigin
	@PostMapping("/adminlogin")
	public ResponseEntity<Admin> loginAdmin(@RequestBody LoginDto credential) {
		
		
		Admin res = lService.loginAdmin(credential);
						
			
		return new ResponseEntity<Admin>(res, HttpStatus.ACCEPTED);
			
		}
	
	
	@PostMapping("/adminlogout")
	@CrossOrigin
	public ResponseEntity<String> adminlogout(@RequestParam("key") String key) {
		
		
		String res = lService.logoutAdmin(key);
						
			
		return new ResponseEntity<String>(res, HttpStatus.ACCEPTED);
			
		}
		
	
	
	
}
