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

    @Autowired
    private DonationTermsRepository donationTermsRepository;

    @Autowired
    private DonationTermsService donationTermsService;

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


    //Kreiranje izvestaja nakon pregleda
    public StuffSurvey save(StuffSurvey stuffSurvey)
    {
        DonationTerms donationTerms = donationTermsService.findById1(stuffSurvey.getDonationTerms().getId());



        if(donationTerms.getSurvey().getP1().equals("YES"))
        {
            donationTerms.setFreeTerm(false);
            donationTermsRepository.save(donationTerms);
        }
        else if(donationTerms.getSurvey().getP2().equals("YES"))
        {
            donationTerms.setFreeTerm(false);
            donationTermsRepository.save(donationTerms);
        }
        else if(donationTerms.getSurvey().getP3().equals("YES"))
        {
            donationTerms.setFreeTerm(false);
            donationTermsRepository.save(donationTerms);
        }
        else if(donationTerms.getSurvey().getP4().equals("YES"))
        {
            donationTerms.setFreeTerm(false);
            donationTermsRepository.save(donationTerms);
        }
        else if(donationTerms.getSurvey().getP5().equals("YES"))
        {

            donationTerms.setFreeTerm(false);
            donationTermsRepository.save(donationTerms);
        }

        else if(donationTerms.getSurvey().getP6().equals("YES"))
        {
            donationTerms.setFreeTerm(false);
            donationTermsRepository.save(donationTerms);
        }
        else if(donationTerms.getSurvey().getP7().equals("YES"))
        {
            donationTerms.setFreeTerm(false);
            donationTermsRepository.save(donationTerms);
        }


        else if(donationTerms.getRegisteredUser().getSex().equals("Female"))
        {
            if(donationTerms.getSurvey().getP8().equals("YES"))
            {
                donationTerms.setFreeTerm(false);
                donationTermsRepository.save(donationTerms);
            }
        }

        if(stuffSurvey.getAccepted_exam().equals("NO"))
        {
            donationTerms.setFreeTerm(false);
            donationTermsRepository.save(donationTerms);
        }


        System.out.println(stuffSurvey.getDonationTerms().isFreeTerm() + " " + "StuffSurvey" + stuffSurvey.getDonationTerms().getSurvey().getP3());

        stuffSurvey.setUser_gave_blood(true);
        return  this.stuffSurveyRepository.save(stuffSurvey);


    }

    //Regulacija Kolicine Utrosene Krvi Tokom Pregleda
    public StuffSurvey UpdateBloodQuantityForCenter(StuffSurvey ss)
    {
        StuffSurvey stuffSurvey = stuffSurveyService.findById(ss.getId());
        BloodCenter bloodCenter = bloodCenterService.findById(ss.getDonationTerms().getBloodCenter().getId());
        DonationTerms donationTerms = donationTermsService.findById1(ss.getDonationTerms().getId());

        //Provera da ukoliko je pregled odbijen da nije dozvoljeno azuriranje kolicine krvi
            if(stuffSurvey.getAccepted_exam().equals("NO"))
            {
                donationTerms.setUser_gave_blood(true);
                donationTermsRepository.save(donationTerms);
                return stuffSurvey;
            }

            if(stuffSurvey.getBlood_type().equals("A"))
            {
                bloodCenter.setBloodA(bloodCenter.getBloodA() + (stuffSurvey.getBlood_quantity() * 0.001));
            }
            else if(stuffSurvey.getBlood_type().equals("B"))
            {
                bloodCenter.setBloodB(bloodCenter.getBloodB() + (stuffSurvey.getBlood_quantity() * 0.001));
            }
            else if(stuffSurvey.getBlood_type().equals("AB"))
            {
                bloodCenter.setBloodAB(bloodCenter.getBloodAB() + (stuffSurvey.getBlood_quantity() * 0.001));
            }
            else if(stuffSurvey.getBlood_type().equals("O"))
            {
                bloodCenter.setBloodO(bloodCenter.getBloodO() + (stuffSurvey.getBlood_quantity() * 0.001));
            }

            System.out.println(bloodCenter.getId() + " " + (bloodCenter.getBloodAB() + stuffSurvey.getBlood_quantity()));
            System.out.println( " Polje USER_GAVE_BLOOD " + " " + stuffSurvey.isUser_gave_blood());

            bloodCenterRepository.save(bloodCenter);

            donationTerms.setUser_gave_blood(true);
            donationTermsRepository.save(donationTerms);

            return stuffSurvey;
    }



}
