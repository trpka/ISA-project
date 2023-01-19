package com.example.ISAproject.repository;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.Calendar;
import com.example.ISAproject.model.DonationTerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DonationTermsRepository extends JpaRepository<DonationTerms, Long>
{
    List<DonationTerms> findByisFree(boolean isFree);
    List<DonationTerms> findByOrderByDate();
    List<DonationTerms> findByOrderByReservationStart();

    @Query("SELECT dt FROM DonationTerms dt WHERE dt.reservationStart < :term and dt.reservationEnd > :term and dt.isFree=1 and  bloodCenter.id= :id")
    List<DonationTerms> getAvailableTerms(@Param("term") LocalDateTime userDate,@Param("id") Long id);
    
    
    
    @Modifying
    @Query( value= "insert into DonationTerms ( date, duration, reservationStart, reservationEnd,bloodCenter.id,calender.id) values (:userDate,:userDuration,:userStart,:userEnd,:bloodId,:calendarId)",
    nativeQuery=true)
    DonationTerms createTerm(@Param("userDate") LocalDateTime userDate,
    		@Param("userDuration") int userDuration,
    		@Param("userStart") LocalDateTime userStart,@Param("userEnd") LocalDateTime userEnd,
    		 @Param("bloodId") Long bloodId,@Param("calendarId") Long calendarId);
}

