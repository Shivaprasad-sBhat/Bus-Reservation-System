package com.masai.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masai.exception.UserException;
import com.masai.model.CurrentSession;
import com.masai.model.Reservation;
import com.masai.model.User;
import com.masai.repository.ResevationDAO;
import com.masai.repository.SessionDao;
import com.masai.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao uDao;
	
	@Autowired
	private SessionDao sDao;
	
	

	@Override
	public User createUser(User user) throws UserException {
	
	     User existingUser = uDao.findByUserName(user.getUserName());
		
	     if(existingUser == null) {
	    	 
	    	List<Reservation> list = new ArrayList<>();
	 		
	 		user.setReservationList(list);
	 		
	 		uDao.save(user);
	 	
	 		return user;
	 	    
	    	 
	     }
	     
	     else 
	    	 
	    	 throw new UserException("User alredy registered");
		
		
		
		
	    
	}
	

	@Override
	public User updateUser(User user, String key) throws UserException {
		
		   CurrentSession existing  = sDao.findByUuid(key);
		   
		   if(existing!=null) {
			   
			   
			   if(user.getUserLoginId() == existing.getId()) {
				   
				   List<Reservation> list = new ArrayList<>();
			 		
			 		user.setReservationList(list);
				   
				   User created = uDao.save(user);
				   
				   return created;
				   
			   }
			   
			   else
				   
				   throw new UserException("User LoginId is wrong");
			   
		   }
		   else
			   
			   throw new UserException("Key Wrong or Not Logged In");
		
	}

	@Override
	public User deleteUser(int userid, String key) throws UserException {
		
		CurrentSession existing  = sDao.findByUuid(key);
		   
		   if(existing!=null) {
			   
			   
			   if(existing.getId() == userid) {
				   
				   Optional<User> delete = uDao.findById(userid);
				   
				   uDao.deleteById(userid);
				   
				   return delete.get();
				   
			   }
			   
			   else
				   
				   throw new UserException("User LoginId is wrong");
			   
		   }
		   else
			   
			   throw new UserException("Key Wrong or Not Logged In");
		
		
	}

	@Override
	public  User viewUser(int userid) throws UserException {
		
		Optional<User> user = 	uDao.findById(userid);
	
		if(user.isPresent())
		
			return user.get();
	
		else
		
			throw new UserException("No user found on this Id");
		
		
	}

	@Override
	public List<User> viewAllUser() throws UserException {
			
		List<User> users = uDao.findAll();
		
		if(users.isEmpty()) throw new UserException("No user found");
		
		else return users;
	
	}

}
