package com.example.insurance.insuranceservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double price;
	
	private Double totalPrice;
	
	private Double insurancePrice;
	
	private String status;
	
	private Long ticketId;
	
	private Long userId;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(Double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Insurance [id=" + id + ", price=" + price + ", totalPrice=" + totalPrice + ", insurancePrice="
				+ insurancePrice + ", status=" + status + ", ticketId=" + ticketId + "]";
	}
	
	
	
}
