package com.example.insurance.insuranceservice.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.crypto.Data;

public class TicketDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5946588456253784253L;

	private Date bookdate;
	
	private Double price;
	
	private Integer totalQuntity;
	
	private String source;
	
	private String destination;

	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getTotalQuntity() {
		return totalQuntity;
	}

	public void setTotalQuntity(Integer totalQuntity) {
		this.totalQuntity = totalQuntity;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getBookdate() {
		return bookdate;
	}

	public void setBookdate(Date bookdate) {
		this.bookdate = bookdate;
	}

	@Override
	public String toString() {
		return "TicketDTO [bookdate=" + bookdate + ", price=" + price + ", totalQuntity=" + totalQuntity + ", source="
				+ source + ", destination=" + destination + "]";
	}
	
	
}

