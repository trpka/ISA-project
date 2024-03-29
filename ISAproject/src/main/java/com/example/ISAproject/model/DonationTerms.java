package com.example.ISAproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeFormatterBuilder;

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
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	//@DateTimeFormat(iso = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime date;
	@Column
	private int duration;
	@Column(name = "freeTerm", nullable = false)
	private boolean freeTerm =true ;

	@Column(name = "reservationStart", nullable = false)
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime reservationStart;

	@Column
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime reservationEnd;

	@Column
	private boolean isRegisteredUserCome=false;

	@Column
	private  boolean user_gave_blood;
	@Column
	private boolean user_got_penalty;


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

	@ManyToOne
	@JoinColumn(name = "survey_id")
	private Survey survey;



	public DonationTerms()
	{

	}

	//NOVI
	public DonationTerms(Long id, LocalDateTime date, int duration, boolean freeTerm, LocalDateTime reservationStart,
						 LocalDateTime reservationEnd, boolean isRegisteredUserCome, boolean user_gave_blood, RegisteredUser registeredUser,
						 BloodCenter bloodCenter, Calendar calendar, Stuff stuff, Survey survey) {
		Id = id;
		this.date = date;
		this.duration = duration;
		this.freeTerm = freeTerm;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.isRegisteredUserCome = isRegisteredUserCome;
		this.user_gave_blood = user_gave_blood;
		this.registeredUser = registeredUser;
		this.bloodCenter = bloodCenter;
		this.calendar = calendar;
		this.stuff = stuff;
		this.survey = survey;
	}

	//Nikolina
	public DonationTerms(Long id, LocalDateTime date, boolean freeTerm, LocalDateTime reservationStart, LocalDateTime reservationEnd,
						 int duration, RegisteredUser registeredUser ,Calendar calendar, BloodCenter bloodCenter,Survey survey )
	{
	super();
	this.Id = id;
	this.date = date;
	this.freeTerm = freeTerm;
	this.reservationStart = reservationStart;
	this.reservationEnd = reservationEnd;
	this.duration = duration;
	this.registeredUser=registeredUser;
	this.calendar=calendar;
	this.bloodCenter=bloodCenter;
	this.survey = survey;
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
						 LocalDateTime reservationEnd, RegisteredUser registeredUser, BloodCenter bloodCenter, Calendar calendar,
						 Stuff stuff, Survey survey)
	{
		Id = id;
		this.date = date;
		this.duration = duration;
		this.freeTerm = freeTerm;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.registeredUser = registeredUser;
		this.bloodCenter = bloodCenter;
		this.calendar = calendar;
		this.stuff = stuff;
		this.survey = survey;
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

	public DonationTerms(LocalDateTime date, int duration, boolean freeTerm, LocalDateTime reservationStart, LocalDateTime reservationEnd, boolean isRegisteredUserCome, RegisteredUser registeredUser, BloodCenter bloodCenter, Calendar calendar, Stuff stuff, Survey survey) {
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
		this.survey = survey;
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

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public boolean isUser_gave_blood() {
		return user_gave_blood;
	}

	public void setUser_gave_blood(boolean user_gave_blood) {
		this.user_gave_blood = user_gave_blood;
	}

	public boolean isUser_got_penalty() {
		return user_got_penalty;
	}

	public void setUser_got_penalty(boolean user_got_penalty) {
		this.user_got_penalty = user_got_penalty;
	}
}



