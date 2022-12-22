package com.example.ISAproject.dto;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.model.RegisteredUser;

import java.time.LocalDateTime;

public class DonationTermsDTO
{
   private Long id;
   private String date;
   private int duration;
   private boolean isFree;
   private String reservationStart;
   private String reservationEnd;
   private RegisteredUser registeredUser;
   private BloodCenter bloodCenter;

   public DonationTermsDTO()
   {

   }

    public DonationTermsDTO(Long id,int duration, boolean isFree, String reservationStart,
                            String reservationEnd, RegisteredUser registeredUser, BloodCenter bloodCenter)
    {
        this.id = id;
        this.duration = duration;
        this.isFree = isFree;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.registeredUser = registeredUser;
        this.bloodCenter = bloodCenter;
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

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public String getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(String reservationStart) {
        this.reservationStart = reservationStart;
    }

    public String getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(String reservationEnd) {
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
}
