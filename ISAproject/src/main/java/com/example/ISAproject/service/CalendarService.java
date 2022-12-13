package com.example.ISAproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.Calendar;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.repository.BloodCenterRepository;
import com.example.ISAproject.repository.CalendarRepository;
import com.example.ISAproject.repository.DonationTermsRepository;

@Service
public class CalendarService {
	
    @Autowired
    private CalendarRepository calendarRepository;
    
    @Autowired
    private DonationTermsRepository donationTermsRepository;

    
	 public List<Calendar> findAll()
	    {   
	        return this.calendarRepository.findAll();
	    }

}
