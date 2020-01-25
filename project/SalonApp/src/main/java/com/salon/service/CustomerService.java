package com.salon.service;

import com.salon.model.Customer;

public interface CustomerService {
	
	//add customer
	public int createCustomer(Customer c);
	
	//get customer
	public Customer getCustomerDetails(Long pk);
	
	//deactivate customer
	public String deactivateCustomer(Long pk);
	
	//update customer details
	public Customer updateCustomerDetails(Long pk, Customer customer);

}
