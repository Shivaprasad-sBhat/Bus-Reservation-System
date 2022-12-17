package com.masai.service;

import com.masai.exception.AdminException;
import com.masai.exception.UserException;
import com.masai.model.LoginDto;
import com.masai.model.User;

public interface LoginService {

	public String loginUser(LoginDto credential) throws UserException;
	
	public String logoutUser(String key) throws UserException;
	
	
	public String loginAdmin(LoginDto credential) throws AdminException;
	
	public String logoutAdmin(String key) throws AdminException;
	
	
}
