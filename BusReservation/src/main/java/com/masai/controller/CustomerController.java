package com.masai.controller;

import java.util.List;


import com.masai.dto.CustomerDto;
import com.masai.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.masai.service.CustomerService;


@RestController
public class CustomerController {

	@Autowired
	private CustomerService uService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@PostMapping("/createUser")
	public ResponseEntity<Customer> createUser(@Valid  @RequestBody Customer customer) {

		customer.setRole("ROLE_CUSTOMER");

		customer.setPassword(passwordEncoder.encode(customer.getPassword()));

		Customer cs = uService.createCustomer(customer);
	     
		return new ResponseEntity<Customer>(cs, HttpStatus.ACCEPTED);
	     
	}
	
	

	@PutMapping("/updateUser")
	public ResponseEntity<Customer> updateUser(@Valid @RequestBody CustomerDto customerDto ){

		Customer cs = uService.updateCustomer(customerDto);
		
		
		return new ResponseEntity<Customer>(cs, HttpStatus.ACCEPTED);
		
	}
	
	

	@DeleteMapping("/deleteUser")
	public ResponseEntity<Customer> deleteUser(){

		Customer cs = uService.deleteCustomer();
		
		
		return new ResponseEntity<Customer>(cs, HttpStatus.ACCEPTED);
		
	}
	

	@GetMapping("/getCurrentUser")
	public ResponseEntity<Customer> getCurrentUser(){

		Customer cs = uService.viewCustomer();
		
		
		return new ResponseEntity<Customer>(cs, HttpStatus.ACCEPTED);
		
	}
	
	

	@GetMapping("/getAllUser")
	public ResponseEntity<List<Customer>> getAllUser(){
		
		List<Customer> cs = uService.viewAllCustomer();
		
		
		return new ResponseEntity<List<Customer>>(cs, HttpStatus.ACCEPTED);
		
	}
	
	
}
