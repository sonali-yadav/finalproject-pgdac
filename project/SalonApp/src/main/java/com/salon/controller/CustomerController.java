package com.salon.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salon.model.Customer;
import com.salon.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	CustomerService cservice;
	
	//get customer details
	@GetMapping("/profile/{pk}")
	public Customer getCustomer(@PathVariable("pk") Long pk) {
		return cservice.getCustomerDetails(pk);
	}
	
	//adding a new customer
	@PostMapping(value = "/add")
	public int create(@Valid @RequestBody Customer customer) {
		return cservice.createCustomer(customer);
	}
	
	//deactivate a customer
	@GetMapping("/deactivate/{pk}")
	public String deactivate(@PathVariable("pk") Long pk) {
		return cservice.deactivateCustomer(pk);
	}
	
	//update customer details
	@PutMapping(value = "/update")
	public Customer update(@RequestBody Customer customer) {
		return cservice.updateCustomerDetails(customer.getPk(), customer);
	}
}
