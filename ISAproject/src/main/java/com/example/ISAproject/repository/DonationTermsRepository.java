package com.example.ISAproject.repository;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.DonationTerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationTermsRepository extends JpaRepository<DonationTerms, Long>
{
    List<DonationTerms> findByisFree(boolean isFree);


}

