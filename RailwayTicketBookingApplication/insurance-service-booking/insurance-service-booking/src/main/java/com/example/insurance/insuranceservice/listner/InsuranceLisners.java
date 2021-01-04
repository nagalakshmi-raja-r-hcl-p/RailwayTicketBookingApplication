package com.example.insurance.insuranceservice.listner;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.example.insurance.insuranceservice.entity.Insurance;
import com.example.insurance.insuranceservice.repository.InsuranceRepository;
import com.example.jms.InsuranceRquestDTO;
import com.example.jms.PaymentRequestDTO;
import com.example.jms.PaymentResponseDTO;
import com.example.sbDemo.demosbDemo.exceptionhandler.MyResourceNotFoundException;


@Component
public class InsuranceLisners {
	
		@Autowired
		InsuranceRepository insuranceRepository;
		
		@Autowired
		private JmsMessagingTemplate jmsMessagingTemplate;
		
		private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceLisners.class);

		@JmsListener(destination = "insurance", containerFactory = "queueConnectionFactory")
		public void receiveQueue(InsuranceRquestDTO insuranceRquestDTO) throws MyResourceNotFoundException{
			LOGGER.info("Listening to insurance topic for " + insuranceRquestDTO.getTicketId());
					Insurance insurance = new Insurance(); 
					insurance.setStatus("PENDING");
				  insurance.setTicketId(insuranceRquestDTO.getTicketId());
				  insurance.setInsurancePrice(100D);
				  insurance.setPrice(insuranceRquestDTO.getPrice());
				  insurance.setTotalPrice(insuranceRquestDTO.getPrice() - 100D);
				  insurance.setUserId(insuranceRquestDTO.getUserId());
				  
				  Insurance persistedInsurance = insuranceRepository.save(insurance);
				 
				  LOGGER.info("Saved Insurance details " + insuranceRquestDTO.getTicketId());
				  
				  PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
				  BeanUtils.copyProperties(persistedInsurance, paymentRequestDTO);
				  paymentRequestDTO.setInsuranceId(persistedInsurance.getId());
				  this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue("payment"),paymentRequestDTO);
				  LOGGER.info("calling payment listners " + paymentRequestDTO.toString());
		}
		
		@JmsListener(destination = "paymentResponse",containerFactory = "topicConnectionFactory") 
		public void receiveQueue(PaymentResponseDTO paymentResponseDTO) throws MyResourceNotFoundException{
			
			System.out.println("update :"+paymentResponseDTO);

			if (paymentResponseDTO.getStatus().equals("DONE")) {			
		
				Insurance insurance = insuranceRepository.findByTicketId(paymentResponseDTO.getTicketId());	
				insurance.setStatus("COMPLETED");
				insuranceRepository.save(insurance);
				LOGGER.info("Saved Payment details for" + paymentResponseDTO.getTicketId());
			
			} 
			
		}
}
