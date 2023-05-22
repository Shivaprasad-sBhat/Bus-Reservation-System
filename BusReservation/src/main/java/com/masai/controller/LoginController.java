package com.masai.controller;

import com.masai.model.Admin;
import com.masai.model.Customer;
import com.masai.model.User;
import com.masai.repository.AdminDao;
import com.masai.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class LoginController {


	@Autowired
	private AdminDao adminDao;

	@Autowired
	private CustomerDao customerDao;

	@GetMapping("/signIn")
	public ResponseEntity<User> loginUser(Authentication auth) {

		User user  = null;


		List<GrantedAuthority> grantedAuthorityList = (List<GrantedAuthority>) auth.getAuthorities();

		String role = grantedAuthorityList.get(0).toString();


		switch (role) {

			case "ROLE_CUSTOMER" :  Optional<Customer> customer =  customerDao.findByName(auth.getName());

			                     user = customer.get();

								 break;

			case "ROLE_ADMIN" : 	Optional<Admin> admin = adminDao.findByName(auth.getName());

								user = admin.get();

								break;


			default:
		}




		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
			
		}

}
