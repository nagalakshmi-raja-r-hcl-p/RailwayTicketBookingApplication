package com.example.sbDemo.demosbDemo.service.impl;


import java.util.Optional;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.jms.InsuranceRquestDTO;
import com.example.sbDemo.demosbDemo.dto.TicketDTO;
import com.example.sbDemo.demosbDemo.entity.Ticket;
import com.example.sbDemo.demosbDemo.repository.TicketRepository;
import com.example.sbDemo.demosbDemo.service.TicketService;

@Service
public class TicketServieImpl implements TicketService {
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Override
	public Long ticketBooking(TicketDTO ticketDTO) {
		Ticket ticket = new Ticket();
		BeanUtils.copyProperties(ticketDTO, ticket);
		ticket.setStatus("PENDING");
		Ticket persistedTicket = ticketRepository.save(ticket);	
		ticketRepository.flush();
		System.out.println(persistedTicket);
		this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue("insurance"), new InsuranceRquestDTO(persistedTicket.getId(),
				persistedTicket.getPrice(), persistedTicket.getUserId()));
		
		return persistedTicket.getId();
		
	}

	@Override
	public Ticket getTicketById(Long id) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		
		if(ticket.isPresent()) {
			return ticket.get();
		}
		return null;
	}
	
	
}
