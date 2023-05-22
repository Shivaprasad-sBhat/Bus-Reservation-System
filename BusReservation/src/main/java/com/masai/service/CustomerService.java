package com.masai.service;

import java.util.List;
import com.masai.dto.CustomerDto;
import com.masai.exception.CustomerException;
import com.masai.model.Customer;



public interface CustomerService {
	
	public Customer createCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(CustomerDto customerDto) throws CustomerException;
	
	public Customer deleteCustomer() throws CustomerException;
	
	public Customer viewCustomer() throws CustomerException;
	
	public List<Customer> viewAllCustomer() throws CustomerException ;

}
