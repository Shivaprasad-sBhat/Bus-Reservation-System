package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.masai.dto.CustomerDto;
import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.masai.model.Reservation;
import com.masai.repository.SessionDao;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private SessionDao sDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	

	@Override
	public Customer createCustomer(Customer customer) throws CustomerException {
	
	     Optional<Customer> existingUser = cDao.findByName(customer.getName());
		
	     if(existingUser.isEmpty()) {


			 Pattern pattern = Pattern.compile("@masai" , Pattern.CASE_INSENSITIVE);

			 Matcher matcher = pattern.matcher(customer.getName());

			 boolean matchfound = matcher.find();

			 if(matchfound) throw new CustomerException("Customer name  can't set as @masai");
	    	 
	    	List<Reservation> list = new ArrayList<>();

			 customer.setReservationList(list);
	 		
	 			return cDao.save(customer);


	     }
	     
	     else 
	    	 
	    	 throw new CustomerException("Customer already registered");

	    
	}
	

	@Override
	public Customer updateCustomer(CustomerDto userDto) throws CustomerException {


		Authentication auth =  SecurityContextHolder.getContext().getAuthentication();

		Optional<Customer> CustomerExist = cDao.findByName(auth.getName());

		if(CustomerExist.isPresent()){

			Customer customer = CustomerExist.get();

			if(userDto.getUserName() != null) {

				Pattern pattern = Pattern.compile("@masai" , Pattern.CASE_INSENSITIVE);

				Matcher matcher = pattern.matcher(userDto.getUserName());

				boolean matchfound = matcher.find();

				if(matchfound) throw new CustomerException("Customer name  can't set as @masai");

				customer.setName(userDto.getUserName());
			}

			if(userDto.getPassword() != null) customer.setPassword(passwordEncoder.encode(userDto.getPassword()));

			if(userDto.getContact() != null) customer.setContact(userDto.getContact());

			if(userDto.getEmail() != null) customer.setEmail(userDto.getEmail());

			if(userDto.getFirstName() != null) customer.setFirstName(userDto.getFirstName());

			if(userDto.getLastName() != null) customer.setLastName(userDto.getLastName());


			return cDao.save(customer);

		}
		// Its Definitely execute the if block not came else block
		else throw new CustomerException("Customer not exist");


	}

	
	
	@Override
	public Customer deleteCustomer() throws CustomerException {


		Authentication auth = 	SecurityContextHolder.getContext().getAuthentication();
		
		Optional<Customer>  customerExist =  cDao.findByName(auth.getName());
		
		if(customerExist.isPresent()) {

			Customer customer = customerExist.get();

			 cDao.delete(customer);

//			 Authentication delete = new UsernamePasswordAuthenticationToken(null , null , null);
//
//			 SecurityContextHolder.getContext().setAuthentication(delete);

			 return customer;
		}

		// else block never execute bcz user can acces this endpoint if he login. so login we set there authentication object

		else
			
			throw new CustomerException("Customer not found");

		
		
	}

	
	
	@Override
	public  Customer viewCustomer() throws CustomerException {

		Authentication auth =	SecurityContextHolder.getContext().getAuthentication();
		
		Optional<Customer> customer = 	cDao.findByName(auth.getName());
	
		if(customer.isPresent())
		
			return customer.get();
	
		else
		
			throw new CustomerException("No customers found ...!");
		
		
	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {
			
		List<Customer> customers = cDao.findAll();
		
		if(customers.isEmpty()) throw new CustomerException("No customers found");
		
		else return customers;
	
	}

}
