package com.example.ISAproject.controllers;

import com.example.ISAproject.model.StuffSurvey;
import com.example.ISAproject.model.Survey;
import com.example.ISAproject.service.StuffSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class StuffSurveyController
{
    @Autowired
    private StuffSurveyService stuffSurveyService;

    @RequestMapping(value="api/stuff-survey",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StuffSurvey> save(@RequestBody StuffSurvey survey)
    {
        StuffSurvey savedSurvey=this.stuffSurveyService.save(survey);
        return new ResponseEntity<>(savedSurvey, HttpStatus.CREATED);
    }



}
