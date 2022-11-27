package com.example.ISAproject.service;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.model.Stuff;
import com.example.ISAproject.repository.BloodCenterRepository;
import com.example.ISAproject.repository.DonationTermsRepository;
import com.example.ISAproject.repository.StuffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DonationTermsService
{
    @Autowired
    private DonationTermsRepository donationTermsRepository;
    @Autowired
    private BloodCenterRepository bloodCenterRepository;
    @Autowired
    private BloodCenterService bloodCenterService;
    @Autowired
    private StuffRepository stuffReposiory;

    public List<DonationTerms> findAll() {
        return this.donationTermsRepository.findAll();
    }

    //Pretraga Termina po centru(NE GLEDAJ OVU F-JU)
    public List<DonationTerms> findByCenter(Long id)
    {
        Optional<DonationTerms> opt=this.donationTermsRepository.findById(id);
        if(!opt.isPresent())
        {
            return null;
        }
        return (List<DonationTerms>) opt.get();

    }

    //Pretraga Termina Po Centru kojem pripadaju
    public List<DonationTerms> findAllTermsByCentre(Long id)
    {
        List<DonationTerms> allTerms = donationTermsRepository.findAll();
        List<DonationTerms> findedTerms = new ArrayList<>();

        for(DonationTerms dt: allTerms)
        {
            if(dt.getBloodCenter().getId() == id)
            {
                findedTerms.add(dt);
            }
        }

        return findedTerms;
    }


    //Prikazivanje Lista Slobodnih i Zauzetih termina
    public List<DonationTerms> findFreeTerms(boolean isFree)
    {
        List<DonationTerms> all_terms =  this.donationTermsRepository.findAll();
        List<DonationTerms> free_terms = new ArrayList<>();
        List<DonationTerms> reserved_terms = new ArrayList<>();

        for(DonationTerms dt: all_terms)
        {
            if(dt.isFree() == true)
            {
                free_terms.add(dt);
            }
            else
            {
                reserved_terms.add(dt);
            }
        }

        if(isFree == true)
        {
            return free_terms;
        }
        else
        {
            return reserved_terms;
        }
    }

    //Kreiranje Slobodnih Termina Za davanje krvi koje ce korisnici rezervisati jednim klikom
    @Transactional(readOnly=false)
    public DonationTerms createFreeTermForCenter(DonationTerms dt) throws PessimisticLockingFailureException, DateTimeException {
        //BloodCenter bloodCenter = bloodCenterRepository.getById(dt.getBloodCenter().getId());
        BloodCenter bloodCenter = bloodCenterService.findById(dt.getBloodCenter().getId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime start = LocalDateTime.parse(dt.getReservationStart().toString(),formatter);
        LocalDateTime end = LocalDateTime.parse(dt.getReservationEnd().toString(),formatter);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        DonationTerms donationTerms = new DonationTerms(dt.getId(),start, end, dt.getDuration(),
                                                        dt.isFree(), dt.getRegisteredUser(), bloodCenter);

        donationTermsRepository.save(donationTerms);

        String message="There is new available terms for BloodCenter "+ bloodCenter.getCenterName();

        return donationTerms;
    }


}
