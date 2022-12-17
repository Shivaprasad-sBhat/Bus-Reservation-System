package com.masai.service;

import com.masai.exception.AdminException;
import com.masai.exception.UserException;
import com.masai.model.Admin;
import com.masai.model.LoginDto;
import com.masai.model.User;

public interface LoginService {

	public User loginUser(LoginDto credential) throws UserException;
	
	public String logoutUser(String key) throws UserException;
	
	
	public Admin loginAdmin(LoginDto credential) throws AdminException;
	
	public String logoutAdmin(String key) throws AdminException;
	
	
}
