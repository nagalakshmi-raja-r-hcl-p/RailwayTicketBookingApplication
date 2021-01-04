package com.example.sbDemo.demosbDemo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket implements Serializable {

	
	private static final long serialVersionUID = -2757925966345363451L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date bookdate;
	
	private Double price;
	
	private Integer totalQuntity;
	
	private String source;
	
	private String destination;
	
	private String status;
	
	private Long userId;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Date getBookdate() {
		return bookdate;
	}

	public void setBookdate(Date bookdate) {
		this.bookdate = bookdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", bookdate=" + bookdate + ", price=" + price + ", totalQuntity=" + totalQuntity
				+ ", source=" + source + ", destination=" + destination + ", status=" + status + "]";
	}
	

}

