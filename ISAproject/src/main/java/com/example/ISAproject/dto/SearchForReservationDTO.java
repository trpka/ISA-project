package com.example.ISAproject.dto;


import java.time.LocalDateTime;

public class SearchForReservationDTO {

	private Long id;
	private String dateAndTime;
	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}



	public SearchForReservationDTO(Long id, String dateAndTime) {
		super();
		this.id = id;
		this.dateAndTime = dateAndTime;
	}


	public SearchForReservationDTO() {
		
	}
}
