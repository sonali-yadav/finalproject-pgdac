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

import com.salon.model.User;
import com.salon.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserService cservice;
	
	//get user details
	@GetMapping("/profile/{pk}")
	public User getUser(@PathVariable("pk") Long pk) {
		return cservice.getUserDetails(pk);
	}
	
	//adding a new User
	@PostMapping(value = "/add")
	public int create(@Valid @RequestBody User user) {
		return cservice.createUser(user);
	}
	
	//deactivate a customer
	@GetMapping(value="/deactivate/{pk}",produces = "application/json")
	public Map<String,String> deactivate(@PathVariable("pk") Long pk) {
//		return cservice.deactivateCustomer(pk);
		return Collections.singletonMap("message",cservice.deactivateUser(pk));
	}
	
	//update customer details
	@PutMapping(value = "/update")
	public User update(@RequestBody User user) {
		return cservice.updateUserDetails(user.getPk(), user);
	}
	
	//cus
}
