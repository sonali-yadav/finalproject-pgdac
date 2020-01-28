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

import com.salon.model.Salon;
import com.salon.service.SalonService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/customer")
public class SalonController {

	@Autowired
	SalonService sservice;

	// get Salon details
	@GetMapping("/profile/{pk}")
	public Salon getCustomer(@PathVariable("pk") Long pk) {
		return sservice.getSalonDetails(pk);
	}

	// adding a new Salon
	@PostMapping(value = "/add")
	public int create(@Valid @RequestBody Salon salon) {
		return sservice.createSalon(salon);
	}

	// deactivate a Salon
	@GetMapping(value = "/deactivate/{pk}", produces = "application/json")
	public Map<String, String> deactivate(@PathVariable("pk") Long pk) {
		return Collections.singletonMap("message", sservice.deactivateSalon(pk));
	}

	// update Salon details
	@PutMapping(value = "/update")
	public Salon update(@RequestBody Salon salon) {
		return sservice.updateSalonDetails(salon.getPk(), salon);
	}

	//add a service to a salon
//		public int createService(Service serv, Salon salon);
	
	// deactivate a service for a salon
	//public int deactivateService();

	// update a service's details

	// get recent orders for salon

	// get all reviews
}