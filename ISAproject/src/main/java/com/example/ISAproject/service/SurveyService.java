package com.example.ISAproject.service;

import com.example.ISAproject.model.Survey;
import com.example.ISAproject.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public Survey save(Survey survey)
    {
        return  this.surveyRepository.save(survey);
    }
}
