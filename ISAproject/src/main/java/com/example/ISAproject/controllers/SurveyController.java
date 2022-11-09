package com.example.ISAproject.controllers;

import com.example.ISAproject.model.Survey;
import com.example.ISAproject.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @RequestMapping(value="api/survey",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Survey> save(@RequestBody Survey survey){
        Survey savedSurvey=this.surveyService.save(survey);
        return new ResponseEntity<>(savedSurvey, HttpStatus.CREATED);
    }
}
