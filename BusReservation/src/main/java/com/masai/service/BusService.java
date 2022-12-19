package com.masai.service;

import java.util.List;

import com.masai.exception.BusException;
import com.masai.exception.RouteException;
import com.masai.model.Bus;


public interface BusService {
	
	public Bus addBus(Bus bus , int busid) throws BusException, RouteException;
	
	public Bus updateBus(Bus bus,Integer routeId) throws BusException;
	
	public Bus deleteBus(Integer busId) throws BusException;
	
	public Bus viewBus(Integer busId) throws BusException;
	
	public List<Bus> viewBusByType(String busType) throws BusException;
	
	public List<Bus> viewAllBus() throws BusException;

	
}
