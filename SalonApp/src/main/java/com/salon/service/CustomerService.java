package com.salon.service;

import com.salon.model.Users;

public interface CustomerService {
	
	//add customer
	public int createCustomer(Users c);
	
	//get customer
	public Users getCustomerDetails(Long pk);
	
	//deactivate customer
	public String deactivateCustomer(Long pk);
	
	//update customer details
	public Users updateCustomerDetails(Long pk, Users customer);
	
}
