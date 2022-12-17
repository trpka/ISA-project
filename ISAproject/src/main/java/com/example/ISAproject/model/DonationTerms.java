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
	@Column(name = "isFree", nullable = false)
	private boolean isFree;

	@Column(name = "reservationStart", nullable = false)
	private LocalDateTime reservationStart;

	@Column(name = "reservationEnd", nullable = false)
	private LocalDateTime reservationEnd;

	@Column
	private boolean isRegisteredUserCome;



	@ManyToOne
	@JoinColumn(name = "registered_user_id")
	private RegisteredUser registeredUser;

	@ManyToOne
	@JoinColumn(name = "profile_center_id")
	private BloodCenter bloodCenter;

	@ManyToOne
	@JoinColumn(name = "calendar_id")
	private Calendar calendar;

	//Povratna Veza sa Osobljem centra
	@ManyToOne
	@JoinColumn(name = "Stuff")
	private Stuff stuff;





	public DonationTerms()
	{

	}
	
	//Nikolina
	public DonationTerms(Long id,LocalDateTime date, LocalDateTime reservationStart, LocalDateTime reservationEnd, int duration,
			 boolean isFree,BloodCenter bloodCenter,Calendar calendar)
	{
	super();
	this.Id = id;
	this.date = date;
	this.reservationStart = reservationStart;
	this.reservationEnd = reservationEnd;
	this.duration = duration;
	this.isFree=isFree;
	this.bloodCenter = bloodCenter;
	this.calendar=calendar;
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

	public DonationTerms(Long id, LocalDateTime date, LocalDateTime reservationStart, LocalDateTime reservationEnd, int duration,
						 boolean isFree, RegisteredUser registeredUser, BloodCenter bloodCenter)
	{
		super();
		this.Id = id;
		this.date = date;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.duration = duration;
		this.isFree = isFree;
		this.registeredUser = registeredUser;
		this.bloodCenter = bloodCenter;
	}

	public DonationTerms(Long id, int duration, boolean isFree, RegisteredUser registeredUser, BloodCenter bloodCenter)
	{
		super();
		this.Id = id;
		this.duration = duration;
		this.isFree = isFree;
		this.registeredUser = registeredUser;
		this.bloodCenter = bloodCenter;
	}

	public DonationTerms(Long id, LocalDateTime date, int duration, boolean isFree, LocalDateTime reservationStart, LocalDateTime reservationEnd, boolean isRegisteredUserCome, RegisteredUser registeredUser, BloodCenter bloodCenter, Calendar calendar) {
		Id = id;
		this.date = date;
		this.duration = duration;
		this.isFree = isFree;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.isRegisteredUserCome = isRegisteredUserCome;
		this.registeredUser = registeredUser;
		this.bloodCenter = bloodCenter;
		this.calendar = calendar;
	}

	//Aleksin Konstruktor-- Za kreiranje Termina koji se brzo rezervisu
	public DonationTerms(Long id, LocalDateTime date, int duration, boolean isFree, LocalDateTime reservationStart,
						 LocalDateTime reservationEnd, boolean isRegisteredUserCome, RegisteredUser registeredUser,
						 BloodCenter bloodCenter, Calendar calendar, Stuff stuff) {
		Id = id;
		this.date = date;
		this.duration = duration;
		this.isFree = isFree;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.isRegisteredUserCome = isRegisteredUserCome;
		this.registeredUser = registeredUser;
		this.bloodCenter = bloodCenter;
		this.calendar = calendar;
		this.stuff = stuff;
	}

	public DonationTerms(DonationTerms donationTerms) {
		this.date = donationTerms.getDate();
		this.duration = donationTerms.getDuration();
		this.isFree = donationTerms.isFree();
		this.reservationStart = donationTerms.getReservationStart();
		this.reservationEnd = donationTerms.getReservationEnd();
		this.isRegisteredUserCome = donationTerms.isRegisteredUserCome();
		this.registeredUser = donationTerms.getRegisteredUser();
		this.bloodCenter = donationTerms.getBloodCenter();
		this.calendar = donationTerms.getCalendar();
		this.stuff = donationTerms.getStuff();
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


	public BloodCenter getBloodCenter() {
		return bloodCenter;
	}


	public void setBloodCenter(BloodCenter bloodCenter) {
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

	public boolean isRegisteredUserCome() {
		return isRegisteredUserCome;
	}

	public void setRegisteredUserCome(boolean registeredUserCome) {
		isRegisteredUserCome = registeredUserCome;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public Stuff getStuff() {
		return stuff;
	}

	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
	}
}