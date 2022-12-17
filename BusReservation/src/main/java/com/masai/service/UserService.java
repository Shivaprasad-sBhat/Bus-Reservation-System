package com.masai.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.masai.exception.UserException;
import com.masai.model.User;

public interface UserService {
	
	public User createUser(User user) throws UserException;
	
	public User updateUser(User user , String key) throws UserException;
	
	public User deleteUser(int userid , String  key) throws UserException;
	
	public User viewUser(int userid) throws UserException;
	
	public List<User> viewAllUser() throws UserException;

}
