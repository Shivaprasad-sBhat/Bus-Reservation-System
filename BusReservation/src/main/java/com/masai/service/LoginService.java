package com.masai.service;

import com.masai.exception.AdminException;
import com.masai.exception.CustomerException;
import com.masai.model.Admin;
import com.masai.model.LoginDto;
import com.masai.model.User;

public interface LoginService {

	public User loginUser(LoginDto credential) throws CustomerException;
	
	public String logoutUser(String key) throws CustomerException;
	
	
	public Admin loginAdmin(LoginDto credential) throws AdminException;
	
	public String logoutAdmin(String key) throws AdminException;
	
	
}
