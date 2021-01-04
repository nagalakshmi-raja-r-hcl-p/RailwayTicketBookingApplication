package com.example.jms;

public class PaymentResponseDTO {
	
	@Override
	public String toString() {
		return "PaymentResDTO [ticketId=" + ticketId + ", status=" + status + "]";
	}

	private Long ticketId;

	private String status;

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PaymentResponseDTO(Long ticketId, String status) {
		super();
		this.ticketId = ticketId;
		this.status = status;
	}

	public PaymentResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
