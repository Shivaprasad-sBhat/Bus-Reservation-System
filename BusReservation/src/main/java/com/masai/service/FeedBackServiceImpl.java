package com.masai.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.FeedBackException;
import com.masai.model.Feedback;
import com.masai.model.Reservation;
import com.masai.model.User;
import com.masai.repository.FeedBackDao;
import com.masai.repository.ReservationDao;
import com.masai.repository.UserDao;
@Service
public class FeedBackServiceImpl implements FeedBackService {

	
	@Autowired
	
	private UserDao uDao;
	
	
	@Autowired
	
	private FeedBackDao fDao;
	
	@Autowired
	private ReservationDao rDao;
	
	
	@Override
	public Feedback addFeedBack(Feedback fb, int userId , int reservationid) throws FeedBackException {
	
		
		 Optional<User> existing =  uDao.findById(userId);
		 
		 if(existing.isPresent()) {
			 
			  Optional<Reservation> rs =  rDao.findById(reservationid);
			  
			  Reservation reservation = rs.get();
			 
			 User us = existing.get();
			 
			 fb.setUser(us);
			 
			 fb.setReserc(reservation);
			 
			 fb.setFeedBackDate(LocalDate.now());
			 
			 return fDao.save(fb);
			 
		 }
		 
		 else
			 
			 throw new FeedBackException("User not found");

	}


	@Override
	public Feedback updateFeedBack(Feedback fb) throws FeedBackException {
		
	      Optional<Feedback> fedbck = 	fDao.findById(fb.getFeedBackId());
	      
	      if(fedbck.isPresent()) {
	    	  
	    	  Feedback f = fedbck.get();
	    	  
	    	  fb.setUser(f.getUser());
	    	  
	    	  fb.setReserc(f.getReserc());
	    	  
	    	  fb.setFeedBackDate(LocalDate.now());
	    	  
	    	  return fDao.save(fb);
	    	  
	      }
	      else
	    	  throw new FeedBackException("Feedback id wrong");
		
		
	}


	@Override
	public Feedback viewFeedBack(int fedbackid) throws FeedBackException {
		
		
		Optional<Feedback> fedbck = 	fDao.findById(fedbackid);
	      
	      if(fedbck.isPresent()) {
	    	  
	    	  return fedbck.get();
	    	  
	      }
	      else
	    	  throw new FeedBackException("No feedback is available with this Id");
	
		
	}


	@Override
	public List<Feedback> viewAllFeedBack( int userid) throws FeedBackException {
		
		
		    List<Feedback> allFb = fDao.findAll();
		    
		    if(!allFb.isEmpty()) {
		    	
		    	
		    	List<Feedback> userFeedBack = new ArrayList<>();
		    	
		    	allFb.forEach(el ->{
		    		
		    		
		    		if(el.getUser().getUserLoginId() == userid) {
		    		
		    			userFeedBack.add(el);
		    			
		    		}
		    		
		    		
		    	});
		    	
		    	
		    	if(!userFeedBack.isEmpty()) {
		    		
		    		return userFeedBack;
		    	}
		    	
		    	else 
		    		
		    		throw new FeedBackException("No feedBackFound");
		    	
		    	
		    }
		    
		    else
		    	throw new FeedBackException("No FeedBackAvialbale");
		
	}
	
	
	

}
