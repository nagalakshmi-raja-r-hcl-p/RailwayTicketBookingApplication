package com.example.jms;

import java.io.Serializable;



public class InsuranceRquestDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7190916964169522806L;

	private Long ticketId;
	
	private Double price;
	
	private Long userId;


	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "InsuranceReqDTO [ticketId=" + ticketId + ", price=" + price + ", userId=" + userId + "]";
	}
	
}
