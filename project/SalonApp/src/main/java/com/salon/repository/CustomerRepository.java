package com.salon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	// find customer by email
	Customer findByEmail(String email);
}
