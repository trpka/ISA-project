package com.example.ISAproject.dto;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.Calendar;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.model.RegisteredUser;

import java.time.LocalDateTime;

public class DefinedTermDTO
{
   private Long id;
   private String date;
   private int duration;
   private boolean isFree;
   private String reservationStart;
   private String reservationEnd;
   private  RegisteredUser registeredUser;
   private Calendar calendar;
   private BloodCenter center;



public DefinedTermDTO()
   {

   }

    public DefinedTermDTO(Long id,int duration, String date,boolean isFree,String reservationStart ,
    		String reservationEnd,RegisteredUser registeredUser,Calendar calendar,
    		BloodCenter center)
    {
        this.id = id;
        this.duration = duration;
        this.date=date;
        this.isFree=isFree;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.registeredUser = registeredUser;
        this.calendar=calendar;
        this.center=center;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public String getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(String reservationStart) {
        this.reservationStart = reservationStart;
    }
	
    
    
	 public BloodCenter getCenter() {
		return center;
	}

	public void setCenter(BloodCenter center) {
		this.center = center;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	
	

	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(RegisteredUser registeredUser) {
		this.registeredUser = registeredUser;
	}

	public String getReservationEnd() { return reservationEnd; }
	 
	  public void setReservationEnd(String reservationEnd) { this.reservationEnd =
	  reservationEnd; }
	 
	 public Calendar getCalendar() { return calendar; }
	 
	  public void setCalendar(Calendar calendar) { this.calendar = calendar; }
	 
	  
	  public BloodCenter getBloodCenter() { return center; }
		 
	  public void setBloodCenter(BloodCenter center) { this.center = center; }
}
