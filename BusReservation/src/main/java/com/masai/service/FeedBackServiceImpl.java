package com.masai.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.masai.exception.FeedBackException;
import com.masai.model.Feedback;
import com.masai.model.Reservation;
import com.masai.repository.FeedBackDao;
import com.masai.repository.ReservationDao;

@Service
public class FeedBackServiceImpl implements FeedBackService {

	
	@Autowired
	private CustomerDao cDao;
	
	
	@Autowired
	
	private FeedBackDao fDao;
	
	@Autowired
	private ReservationDao rDao;
	
	
	@Override
	public Feedback addFeedBack(Feedback fb, int reservationid) throws FeedBackException {

		 Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
		
		 Optional<Customer> customerExisting =  cDao.findByName(auth.getName());
			 
		 Optional<Reservation> reservationExist =  rDao.findById(reservationid);

		 if(reservationExist.isPresent()){

			 Reservation reservation = reservationExist.get();

			 Customer customer = customerExisting.get();

			 fb.setCustomer(customer);

			 fb.setReserc(reservation);

			 fb.setFeedBackDate(LocalDate.now());

			 return fDao.save(fb);
		 }

		 else throw new FeedBackException("No reservation found on this Id");
			  


	}


	@Override
	public Feedback updateFeedBack(Feedback fb) throws FeedBackException {
		
	      Optional<Feedback> feedback = fDao.findById(fb.getFeedBackId());
	      
	      if(feedback.isPresent()) {
	    	  
	    	  Feedback f = feedback.get();
	    	  
	    	  fb.setCustomer(f.getCustomer());
	    	  
	    	  fb.setReserc(f.getReserc());
	    	  
	    	  fb.setFeedBackDate(LocalDate.now());
	    	  
	    	  return fDao.save(fb);
	    	  
	      }
	      else
	    	  throw new FeedBackException("Feedback id wrong");
		
		
	}


	@Override
	public Feedback viewFeedBack(int fedbackid) throws FeedBackException {
		
		
		Optional<Feedback> fedbck = fDao.findById(fedbackid);
	      
	      if(fedbck.isPresent()) {
	    	  
	    	  return fedbck.get();
	    	  
	      }
	      else
	    	  throw new FeedBackException("No feedback is available with this Id");
	
		
	}


	@Override
	public List<Feedback> viewAllFeedBackOfUser() throws FeedBackException {


			Authentication auth = SecurityContextHolder.getContext().getAuthentication();

			Optional<Customer> customerExist =  cDao.findByName(auth.getName());

			Customer customer = customerExist.get();

		    List<Feedback> allFb = fDao.findAll();
		    
		    if(!allFb.isEmpty()) {
		    	
		    	
		    	List<Feedback> customerFeedBack = new ArrayList<>();
		    	
		    	allFb.forEach(el ->{
		    		
		    		
		    		if(el.getCustomer().getCustomerLoginId() == customer.getCustomerLoginId()) {

						customerFeedBack.add(el);
		    			
		    		}
		    		
		    		
		    	});
		    	
		    	
		    	if(!customerFeedBack.isEmpty()) {
		    		
		    		return customerFeedBack;
		    	}
		    	
		    	else 
		    		
		    		throw new FeedBackException("No feedBackFound");
		    	
		    	
		    }
		    
		    else
		    	throw new FeedBackException("No FeedBack Available");
		
	}
	
	
	@Override
	public List<Feedback> viewAllFeedBacks() throws FeedBackException {
		
		
		    List<Feedback> allFb = fDao.findAll();
		    
		    if(!allFb.isEmpty()) {
		    	
		    	
		    	return allFb;
		    }
		    
		    else
		    	throw new FeedBackException("No FeedBack Available ");
		
	}

}
