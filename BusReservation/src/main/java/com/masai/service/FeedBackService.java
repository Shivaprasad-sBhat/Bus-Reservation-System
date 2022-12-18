package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.FeedBackException;
import com.masai.model.Feedback;


public interface FeedBackService {

	public Feedback addFeedBack(Feedback fb , int userId) throws FeedBackException;
	
	public Feedback updateFeedBack (Feedback fb) throws FeedBackException;
	
	public Feedback viewFeedBack( int fedbackid) throws FeedBackException;
	
	public List<Feedback> viewAllFeedBack(int userid) throws FeedBackException;
	
}
