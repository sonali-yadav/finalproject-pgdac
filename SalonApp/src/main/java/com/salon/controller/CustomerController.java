package com.salon.controller;

import java.util.Collections;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.model.Users;
import com.salon.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	CustomerService cservice;
	
	//get customer details
	@GetMapping("/profile/{pk}")
	public Users getCustomer(@PathVariable("pk") Long pk) {
		return cservice.getCustomerDetails(pk);
	}
	
	//adding a new customer
	@PostMapping(value = "/add")
	public int create(@Valid @RequestBody Users customer) {
		return cservice.createCustomer(customer);
	}
	
	//deactivate a customer
	@GetMapping(value="/deactivate/{pk}",produces = "application/json")
	public Map<String,String> deactivate(@PathVariable("pk") Long pk) {
//		return cservice.deactivateCustomer(pk);
		return Collections.singletonMap("message",cservice.deactivateCustomer(pk));
	}
	
	//update customer details
	@PutMapping(value = "/update")
	public Users update(@RequestBody Users customer) {
		return cservice.updateCustomerDetails(customer.getPk(), customer);
	}
	
	//cus
}
