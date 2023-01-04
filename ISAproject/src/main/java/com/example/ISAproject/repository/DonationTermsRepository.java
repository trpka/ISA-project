package com.example.ISAproject.repository;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.DonationTerms;
import org.springframework.data.jpa.repository.JpaRepository;
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

    @Query("SELECT dt FROM DonationTerms dt WHERE dt.reservationStart < :userDate and dt.reservationEnd > :userDate and dt.isFree=0 and dt.isRegisteredUserCome=0")
    List<DonationTerms> getAvailableTerms(@Param("userDate") LocalDateTime userDate);
    
	/*
	 * @Query
	 * ("SELECT dt FROM DonationTerms dt WHERE dt.isFree=0 and dt.isRegisteredUserCome ORDER BY dt.bloodCenter.averageGradeCentre DESC"
	 * ) List<DonationTerms>sortTermsByCenter();
	 */
}

