package com.salon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.model.Salon;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {

	// find salon by email
	Salon findByEmail(String email);
}
