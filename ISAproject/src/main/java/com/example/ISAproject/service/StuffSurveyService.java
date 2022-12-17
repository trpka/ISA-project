package com.example.ISAproject.service;

import com.example.ISAproject.model.StuffSurvey;
import com.example.ISAproject.repository.StuffSurveyRepository;
import com.example.ISAproject.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuffSurveyService
{
    @Autowired
    private StuffSurveyRepository stuffSurveyRepository;

    public StuffSurvey save(StuffSurvey stuffSurvey)
    {
        return  this.stuffSurveyRepository.save(stuffSurvey);
    }
}
