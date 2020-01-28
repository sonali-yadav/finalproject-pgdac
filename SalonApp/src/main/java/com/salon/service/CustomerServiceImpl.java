package com.salon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.exception.ResourceNotfoundException;
import com.salon.model.Users;
import com.salon.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository crepo;

	// get customer details
	public Users getCustomerDetails(Long pk) {
		return crepo.findById(pk).orElseThrow(() -> new ResourceNotfoundException("Customer", "pk", pk));
	}

	// adding a new customer
	public int createCustomer(Users c) {
		
		//here we will first verify whether this is a new customer
		//only then allow for sign up
		Users cust=crepo.findByEmail(c.getEmail());
		if(cust==null) {
			crepo.save(c);
			return 1;
		} else {
			return 0;
		}
	}

	// deactivate a customer
	public String deactivateCustomer(Long pk) {
		Users cust = crepo.findById(pk).orElseThrow(() -> new ResourceNotfoundException("Customer", "pk", pk));
		cust.setActiveDeactive(0);
		crepo.save(cust);
		return "deactivated";
	}

	// update customer details
	public Users updateCustomerDetails(Long pk, Users customer) {
		Users cust = crepo.findById(pk).orElseThrow(() -> new ResourceNotfoundException("Customer", "pk", pk));
		cust.setFirstName(customer.getFirstName());
		cust.setLastName(customer.getLastName());
		cust.setEmail(customer.getEmail());
		cust.setGender(customer.getGender());
		cust.setContact1(customer.getContact1());
		cust.setContact2(customer.getContact2());
		cust.setActiveDeactive(1);

		Users c = crepo.save(cust);
		return c;
	}
}
