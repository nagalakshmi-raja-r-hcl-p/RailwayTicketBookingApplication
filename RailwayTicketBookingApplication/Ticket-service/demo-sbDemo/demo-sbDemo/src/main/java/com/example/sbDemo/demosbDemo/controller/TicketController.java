package com.example.sbDemo.demosbDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbDemo.demosbDemo.dto.TicketDTO;
import com.example.sbDemo.demosbDemo.entity.Ticket;
import com.example.sbDemo.demosbDemo.exceptionhandler.MyResourceNotFoundException;
import com.example.sbDemo.demosbDemo.service.TicketService;
import com.example.sbDemo.demosbDemo.service.impl.TicketServieImpl;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketServieImpl.class);


	@PostMapping("/ticketBooking") 
	public Long ticketBooking(@RequestBody TicketDTO ticketDTO) {
		Long ticketID;
		
		try{
		    LOGGER.info("Start booking ticket for ", ticketDTO.toString());
		    
			ticketID = ticketService.ticketBooking(ticketDTO);
			
			LOGGER.info("Ticket booked ticket for "+ ticketDTO.getUserId());
		}
		catch(Exception e){
			throw new MyResourceNotFoundException("Invalid data : ");
		}
		
		return ticketID;
	} 
	
	@GetMapping("/getTicketByID/{ticketID}")
	public Ticket getTicketDTO(@PathVariable Long ticketID){
		
		return ticketService.getTicketById(ticketID);		
		
	}
	
	
}
