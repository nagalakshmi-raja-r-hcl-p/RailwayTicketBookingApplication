package com.example.sbDemo.demosbDemo.service;

import org.springframework.stereotype.Service;

import com.example.sbDemo.demosbDemo.dto.TicketDTO;
import com.example.sbDemo.demosbDemo.entity.Ticket;

@Service
public interface TicketService {

	Long ticketBooking(TicketDTO ticketDTO);
	
	Ticket getTicketById(Long id);
}
