package com.example.insurance.insuranceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.insurance.insuranceservice.entity.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

	
	Insurance findByTicketId(Long ticketId); 
}
