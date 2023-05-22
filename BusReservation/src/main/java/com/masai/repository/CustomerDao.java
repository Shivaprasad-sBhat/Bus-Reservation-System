package com.masai.repository;

import com.masai.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>  {

	public Optional<Customer> findByName(String customername);
	
}
