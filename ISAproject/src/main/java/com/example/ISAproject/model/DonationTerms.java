package com.example.ISAproject.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DonationTerms {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column
	private LocalDateTime date;
	@Column
	private int duration;
	@Column
	private boolean isFree;
	
	@Column(name = "reservationStart", nullable = false)
    private LocalDateTime reservationStart;

    @Column(name = "reservationEnd", nullable = false)
    private LocalDateTime reservationEnd;
	
	@ManyToOne
    private RegisteredUser registeredUser;
	

	@ManyToOne
	@JoinColumn(name = "profile_center_id")
	private BloodCenter bloodCenter;
	
	public DonationTerms()
	{
		
	}
	
	
	public DonationTerms(Long id, LocalDateTime reservationStart, LocalDateTime reservationEnd, int duration,
			boolean isFree, RegisteredUser registeredUser, BloodCenter bloodCenter)
	{
		super();
		this.Id = id;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.duration = duration;
		this.isFree = isFree;
		this.registeredUser = registeredUser;
		this.bloodCenter = bloodCenter;
	}
	
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public LocalDateTime getReservationStart() {
		return reservationStart;
	}
	public void setReservationStart(LocalDateTime reservationStart) {
		this.reservationStart = reservationStart;
	}
	public LocalDateTime getReservationEnd() {
		return reservationEnd;
	}
	public void setReservationEnd(LocalDateTime reservationEnd) {
		this.reservationEnd = reservationEnd;
	}
	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}
	public void setRegisteredUser(RegisteredUser registeredUser) {
		this.registeredUser = registeredUser;
	}
	public BloodCenter getProfileCenter() {
		return bloodCenter;
	}
	public void setProfileCenter(BloodCenter bloodCenter) {
		this.bloodCenter = bloodCenter;
	}

	public boolean isFree() {
		return isFree;
	}
	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		this.Id = id;
	}
	

	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
