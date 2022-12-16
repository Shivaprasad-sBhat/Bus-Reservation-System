package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.LoginDto;
import com.masai.model.User;
import com.masai.service.LoginService;



@RestController
public class LoginController {

	@Autowired
	private LoginService lService;
	
	
	
	@PostMapping("/user")
	public ResponseEntity<String> loginUser(@RequestBody LoginDto credential) {
		
		System.out.println(credential);
		
		String res = lService.loginUser(credential);
						
			
		return new ResponseEntity<String>(res, HttpStatus.ACCEPTED);
			
		}
	
	
	@PostMapping("/userlogout")
	public ResponseEntity<String> logoutuser(@RequestParam("key") String key) {
		
		
		String res = lService.logoutUser(key);
						
			
		return new ResponseEntity<String>(res, HttpStatus.ACCEPTED);
			
		}
	
	
	
	/**************************************************************************************/
	
	
	
	@PostMapping("/admin")
	public ResponseEntity<String> loginAdmin(@RequestBody LoginDto credential) {
		
		
		String res = lService.loginAdmin(credential);
						
			
		return new ResponseEntity<String>(res, HttpStatus.ACCEPTED);
			
		}
	
	
	@PostMapping("/adminlogout")
	public ResponseEntity<String> adminlogout(@RequestParam("key") String key) {
		
		
		String res = lService.logoutAdmin(key);
						
			
		return new ResponseEntity<String>(res, HttpStatus.ACCEPTED);
			
		}
		
	
	
	
}
