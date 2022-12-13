package com.example.ISAproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.Calendar;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.service.BloodCenterService;
import com.example.ISAproject.service.CalendarService;
import com.example.ISAproject.service.DonationTermsService;

@RestController
@CrossOrigin
public class CalendarController {
	
	 @Autowired
     private CalendarService calendarService;
	
	 
	 @RequestMapping(value="api/calendars",method = RequestMethod.GET,produces = {
	            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	    public ResponseEntity<List<Calendar>> findAll()
	    {
	        List<Calendar> c= this.calendarService.findAll();
	        return new ResponseEntity<>(c,HttpStatus.OK);
	    }
}
