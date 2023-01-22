package com.example.ISAproject.controllers;

import com.example.ISAproject.dto.ScheduleDonationTermDTO;
import com.example.ISAproject.dto.SurveyRegisteredUserDTO;
import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.model.Survey;
import com.example.ISAproject.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @RequestMapping(value="api/survey",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('REGISTERED_USER')")
    public ResponseEntity<Survey> save(@RequestBody Survey survey){
        Survey savedSurvey=this.surveyService.save(survey);
        return new ResponseEntity<>(savedSurvey, HttpStatus.CREATED);
    }

    @RequestMapping(value="api/survey/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Survey> getById(@PathVariable Long id)
    {

        Survey savedSurvey =this.surveyService.findById(id);

        return new ResponseEntity<>(savedSurvey,HttpStatus.OK);
    }

}
