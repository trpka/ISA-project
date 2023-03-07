package com.example.ISAproject.service;

import com.example.ISAproject.dto.ScheduleDonationTermDTO;
import com.example.ISAproject.dto.SurveyRegisteredUserDTO;
import com.example.ISAproject.model.*;
import com.example.ISAproject.repository.DonationTermsRepository;
import com.example.ISAproject.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private  SurveyService surveyService;




    public Survey findById(Long id)
    {
        Optional<Survey> opt=this.surveyRepository.findById(id);
        if(!opt.isPresent())
        {
            return null;
        }
        return opt.get();
    }

    public Survey findByRegisteredUserId(Long id)
    {
        List<Survey> surveys = this.findAll();
        for (Survey survey:surveys)
        {
            if(survey.getRegisteredUser().getId() == id)
            {
                return survey;
            }
        }
        return null;
    }

    public void delete(Survey survey) {
        this.surveyRepository.delete(survey);
    }

    public Survey save(Survey survey)
    {
        if(this.registeredUserHasFilledOutQuestionnaire(survey.getRegisteredUser().getId()) == false)
        {
            return  this.surveyRepository.save(survey);
        }
        return  null;
    }

    public List<Survey> findAll()
    {
        return this.surveyRepository.findAll();
    }


    public boolean registeredUserHasFilledOutQuestionnaire(Long registeredUserId)
    {
        List<Survey> surveys = this.findAll();
        for(Survey survey:surveys)
        {
            if(survey.getRegisteredUser().getId() == registeredUserId)
            {
                return true;
            }
        }
        return false;
    }
}
