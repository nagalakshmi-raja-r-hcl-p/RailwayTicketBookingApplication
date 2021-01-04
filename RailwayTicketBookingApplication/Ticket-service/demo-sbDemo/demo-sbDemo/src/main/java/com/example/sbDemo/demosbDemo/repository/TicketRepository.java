package com.example.sbDemo.demosbDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sbDemo.demosbDemo.entity.Ticket;


public interface TicketRepository extends JpaRepository<Ticket, Long>{

}