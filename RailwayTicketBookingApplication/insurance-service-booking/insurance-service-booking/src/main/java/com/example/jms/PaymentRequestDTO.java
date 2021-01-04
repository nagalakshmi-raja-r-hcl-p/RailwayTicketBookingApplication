package com.example.jms;

import java.io.Serializable;

public class PaymentRequestDTO implements Serializable {

	private static final long serialVersionUID = -2688732745925912144L;

	private Long insuranceId;
		
	private Double totalPrice;
			
	private Long ticketId;
	
	private Long userId;

	public Long getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Long insuranceId) {
		this.insuranceId = insuranceId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}

