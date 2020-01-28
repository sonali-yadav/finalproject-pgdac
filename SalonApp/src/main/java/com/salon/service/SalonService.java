package com.salon.service;

import com.salon.model.Salon;
import com.salon.model.Service;

public interface SalonService {
	
	//add salon
	public int createSalon(Salon s);
	
	//get salon
	public Salon getSalonDetails(Long pk);
	
	//deactivate salon
	public String deactivateSalon(Long pk);
	
	//update salon details
	public Salon updateSalonDetails(Long pk, Salon salon);
	
	//add a service to a salon
	public int createService(Service serv, Salon salon);
	
	//deactivate a service for a salon
	//public int deactivateService();
	
	//update a service's details
	
	//get recent orders for salon
	
	//get all reviews

}
