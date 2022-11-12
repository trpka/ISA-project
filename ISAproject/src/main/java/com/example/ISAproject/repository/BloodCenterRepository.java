package com.example.ISAproject.repository;

import com.example.ISAproject.model.BloodCenter;

import java.util.List;

import com.example.ISAproject.model.DonationTerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodCenterRepository extends JpaRepository<BloodCenter, Long>
{
	List<BloodCenter> findByOrderByCenterName();
	List<BloodCenter> findByOrderByAverageGradeCentreDesc();
	List<BloodCenter> findByOrderByCity();
   // List<ProfileCenter> findCentersByName(String name);
	//

    //BloodCenter findByCenterName(String centerName);
	List<BloodCenter> findByCenterName(String name);
	List<BloodCenter> findByCenterNameContaining(String namePart);
	List<BloodCenter> findByCity(String city);
	List<BloodCenter> findByAddress(String address);
	List<BloodCenter> findByAverageGradeCentre(Long averageGradeCentre);
	List<BloodCenter> findByAddressAndAverageGradeCentre(String address, Long averageGradeCentre);

    
}
