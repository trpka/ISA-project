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
	@Column(name = "freeTerm", nullable = false)
	private boolean freeTerm =true ;

	@Column(name = "reservationStart", nullable = false)
	private LocalDateTime reservationStart;

	@Column
	private LocalDateTime reservationEnd;

	@Column
	private boolean isRegisteredUserCome=false;



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
	public DonationTerms(Long id, LocalDateTime date, boolean freeTerm, LocalDateTime reservationStart, LocalDateTime reservationEnd,
						 int duration, Calendar calendar, BloodCenter bloodCenter )
	{
	super();
	this.Id = id;
	this.date = date;
	this.freeTerm = freeTerm;
	this.reservationStart = reservationStart;
	this.reservationEnd = reservationEnd;
	this.duration = duration;
	this.calendar=calendar;
	this.bloodCenter=bloodCenter;
	}
	
	//Nikolina
	public DonationTerms(LocalDateTime date, int duraion, boolean freeTerm, LocalDateTime reservationStart, LocalDateTime reservationEnd,
						 Calendar calendar, BloodCenter bloodCenter )
	{
	super();
	this.date = date;
	this.duration = duration;
	this.freeTerm = freeTerm;
	this.reservationStart = reservationStart;
	this.reservationEnd = reservationEnd;
	this.calendar=calendar;
	this.bloodCenter=bloodCenter;
	}

	public DonationTerms(Long id, LocalDateTime reservationStart, LocalDateTime reservationEnd, int duration,
						 boolean freeTerm, RegisteredUser registeredUser, BloodCenter bloodCenter)
	{
		super();
		this.Id = id;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.duration = duration;
		this.freeTerm = freeTerm;
		this.registeredUser = registeredUser;
		this.bloodCenter = bloodCenter;
	}

	public DonationTerms(Long id, LocalDateTime date, LocalDateTime reservationStart, LocalDateTime reservationEnd, int duration,
						 boolean freeTerm, RegisteredUser registeredUser, BloodCenter bloodCenter)
	{
		super();
		this.Id = id;
		this.date = date;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.duration = duration;
		this.freeTerm = freeTerm;
		this.registeredUser = registeredUser;
		this.bloodCenter = bloodCenter;
	}

	public DonationTerms(Long id, int duration, boolean freeTerm, RegisteredUser registeredUser, BloodCenter bloodCenter)
	{
		super();
		this.Id = id;
		this.duration = duration;
		this.freeTerm = freeTerm;
		this.registeredUser = registeredUser;
		this.bloodCenter = bloodCenter;
	}

	public DonationTerms(Long id, LocalDateTime date, int duration, boolean freeTerm, LocalDateTime reservationStart, LocalDateTime reservationEnd, boolean isRegisteredUserCome, RegisteredUser registeredUser, BloodCenter bloodCenter, Calendar calendar) {
		Id = id;
		this.date = date;
		this.duration = duration;
		this.freeTerm = freeTerm;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.isRegisteredUserCome = isRegisteredUserCome;
		this.registeredUser = registeredUser;
		this.bloodCenter = bloodCenter;
		this.calendar = calendar;
	}

	//Aleksin Konstruktor-- Za kreiranje Termina koji se brzo rezervisu
	public DonationTerms(Long id, LocalDateTime date, int duration, boolean freeTerm, LocalDateTime reservationStart,
						 LocalDateTime reservationEnd, boolean isRegisteredUserCome, RegisteredUser registeredUser,
						 BloodCenter bloodCenter, Calendar calendar, Stuff stuff) {
		Id = id;
		this.date = date;
		this.duration = duration;
		this.freeTerm = freeTerm;
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
		this.freeTerm = donationTerms.isFreeTerm();
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


	public boolean isFreeTerm() {
		return freeTerm;
	}
	public void setFreeTerm(boolean isFree) {
		this.freeTerm = isFree;
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