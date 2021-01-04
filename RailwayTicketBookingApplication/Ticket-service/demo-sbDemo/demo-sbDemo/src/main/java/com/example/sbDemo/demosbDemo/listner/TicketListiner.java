package com.example.sbDemo.demosbDemo.listner;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.jms.PaymentResponseDTO;
import com.example.sbDemo.demosbDemo.entity.Ticket;
import com.example.sbDemo.demosbDemo.repository.TicketRepository;
import com.example.sbDemo.demosbDemo.service.impl.TicketServieImpl;


@Component
public class TicketListiner  {

	
	@Autowired
	private TicketRepository ticketRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TicketListiner.class);
	
	@JmsListener(destination = "paymentResponse",containerFactory = "topicConnectionFactory" ) 
	public void receiveQueue(PaymentResponseDTO paymentResponseDTO) {
		
		LOGGER.info("Payment has been completed for", paymentResponseDTO.getTicketId());

		if (paymentResponseDTO.getStatus().equals("DONE")) {
		Optional<Ticket> tickets =	ticketRepository.findById(paymentResponseDTO.getTicketId());
	if (tickets.isPresent()) {
			Ticket ticket = tickets.get();
			ticket.setStatus("BOOKED");
			ticketRepository.save(ticket);
		  }
		}	
		
		LOGGER.info("Payment has been completed and confirmed ticket", paymentResponseDTO.getTicketId());
	}
	
}
