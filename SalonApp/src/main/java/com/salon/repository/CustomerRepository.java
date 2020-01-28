package com.salon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.model.Users;

@Repository
public interface CustomerRepository extends JpaRepository<Users, Long> {

	// find customer by email
	Users findByEmail(String email);
}
