package com.example.sbDemo.demosbDemo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sbDemo.demosbDemo.dto.TicketDTO;
import com.example.sbDemo.demosbDemo.entity.Ticket;
import com.example.sbDemo.demosbDemo.repository.TicketRepository;
import com.example.sbDemo.demosbDemo.service.impl.TicketServieImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest
public class TestingWebApplicationTest {

	@Autowired
	private TicketServieImpl ticketServieImpl;
	

	@Test
	public void ticketBook() throws ParseException  {
		TicketDTO ticketDTO = new TicketDTO();
		String sDate1="31/12/1998";  
	    Date date=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
		ticketDTO.setBookdate(date);
		ticketDTO.setUserId((long) 3);
		ticketDTO.setPrice((double) 200);
		ticketDTO.setTotalQuntity(2);
		ticketDTO.setSource("Chennai");
		ticketDTO.setDestination("Bangalore");
	
		
		Long ticketID = ticketServieImpl.ticketBooking(ticketDTO);	
		
		
		Ticket ticket = ticketServieImpl.getTicketById(ticketID);
		
		
		if (ticket.getStatus()!="")
			assertEquals(ticket.getStatus(), "Booked");
		else
			assertNotEquals(ticket.getStatus(), "Pending");
	}
	
}
