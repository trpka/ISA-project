package com.example.ISAproject.service;

import com.example.ISAproject.model.*;
import com.example.ISAproject.repository.BloodCenterRepository;
import com.example.ISAproject.repository.DonationTermsRepository;
import com.example.ISAproject.repository.StuffSurveyRepository;
import com.example.ISAproject.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StuffSurveyService
{
    @Autowired
    private StuffSurveyRepository stuffSurveyRepository;

    @Autowired
    private BloodCenterService bloodCenterService;

    @Autowired
    private StuffSurveyService stuffSurveyService;

    @Autowired
    private BloodCenterRepository bloodCenterRepository;

    public StuffSurvey findById(Long id)
    {
        Optional<StuffSurvey> opt=this.stuffSurveyRepository.findById(id);
        if(!opt.isPresent())
        {
            return null;
        }
        return opt.get();
    }

    public List<StuffSurvey> getAll()
    {
        return this.stuffSurveyRepository.findAll();
    }


    public StuffSurvey save(StuffSurvey stuffSurvey)
    {
        return  this.stuffSurveyRepository.save(stuffSurvey);
    }

    //Regulacija Kolicine Utrosene Krvi Tokom Pregleda
    public StuffSurvey UpdateBloodQuantityForCenter(StuffSurvey ss)
    {
        StuffSurvey stuffSurvey = stuffSurveyService.findById(ss.getId());
        BloodCenter bloodCenter = bloodCenterService.findById(ss.getDonationTerms().getBloodCenter().getId());

        if(stuffSurvey.getBlood_type().equals("A"))
        {
            bloodCenter.setBloodA(bloodCenter.getBloodA() + stuffSurvey.getBlood_quantity());
        }
        else if(stuffSurvey.getBlood_type().equals("B"))
        {
            bloodCenter.setBloodB(bloodCenter.getBloodB() + stuffSurvey.getBlood_quantity());
        }
        else if(stuffSurvey.getBlood_type().equals("AB"))
        {
            bloodCenter.setBloodAB(bloodCenter.getBloodAB() + stuffSurvey.getBlood_quantity());
        }
        else if(stuffSurvey.getBlood_type().equals("O"))
        {
            bloodCenter.setBloodO(bloodCenter.getBloodO() + stuffSurvey.getBlood_quantity());
        }

        System.out.println(bloodCenter.getId() + " " + (bloodCenter.getBloodAB() + stuffSurvey.getBlood_quantity()));

        bloodCenterRepository.save(bloodCenter);
        return stuffSurvey;
    }



}
