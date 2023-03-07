package com.example.ISAproject.controllers;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.model.StuffSurvey;
import com.example.ISAproject.model.Survey;
import com.example.ISAproject.service.BloodCenterService;
import com.example.ISAproject.service.StuffSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StuffSurveyController
{
    @Autowired
    private StuffSurveyService stuffSurveyService;
    @Autowired
    private BloodCenterService bloodCenterService;

    //Kreiranje novog upitnika od strane korisnika
    @RequestMapping(value="api/stuff-survey",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StuffSurvey> save(@RequestBody StuffSurvey survey)
    {
        StuffSurvey savedSurvey=this.stuffSurveyService.save(survey);
        return new ResponseEntity<>(savedSurvey, HttpStatus.CREATED);
    }

    // Pronalazak Popunjene ankete od strane doktora po ID-ju
    @RequestMapping(value="api/stuff-survey/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<StuffSurvey> getById(@PathVariable Long id)
    {

        StuffSurvey savedSurvey =this.stuffSurveyService.findById(id);

        return new ResponseEntity<>(savedSurvey,HttpStatus.OK);
    }

    //Lista svih popunjenih anketa od strane Stuffa
    @RequestMapping(value="api/stuff-surveys",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<StuffSurvey>> findAll()
    {
        List<StuffSurvey> terms= this.stuffSurveyService.getAll();
        return new ResponseEntity<>(terms, HttpStatus.OK);
    }

    //Azuriranje kolicine krvi u Centru nakon azuriranja
    @RequestMapping(value="api/update-blood",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StuffSurvey> updateBlood(@RequestBody StuffSurvey ss)
    {
        BloodCenter bloodCenter = this.bloodCenterService.findById(ss.getDonationTerms().getBloodCenter().getId());
        StuffSurvey stuffSurvey = this.stuffSurveyService.UpdateBloodQuantityForCenter(ss);

        System.out.println(stuffSurvey.getBlood_type() + " " + stuffSurvey.getBlood_quantity());

        System.out.println(stuffSurvey.getDonationTerms().getBloodCenter().getId()  + " " + bloodCenter.getId());

        return new ResponseEntity<>(stuffSurvey, HttpStatus.CREATED);
    }



}
