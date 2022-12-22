package com.example.ISAproject.dto;

import com.example.ISAproject.model.DonationTerms;

import java.time.LocalDateTime;

public class DefinedTermDTO
{
   private Long id;
   private String date;
   private int duration;
   private String reservationStart;
  // private String reservationEnd;
 //  private Calendar calendar;



public DefinedTermDTO()
   {

   }

    public DefinedTermDTO(Long id,int duration, String date,String reservationStart)
    {
        this.id = id;
        this.duration = duration;
        this.date=date;
        this.reservationStart = reservationStart;
    //    this.reservationEnd = reservationEnd;
      //  this.calendar=calendar;
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
	
/*	 public String getReservationEnd() { return reservationEnd; }
	 
	  public void setReservationEnd(String reservationEnd) { this.reservationEnd =
	  reservationEnd; }
	 
	 * public Calendar getCalendar() { return calendar; }
	 * 
	 * public void setCalendar(Calendar calendar) { this.calendar = calendar; }
	 */
}
