package com.example.ISAproject.service;

import com.example.ISAproject.dto.PasswordChangeDTO;
import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.model.Stuff;
import com.example.ISAproject.repository.DonationTermsRepository;
import com.example.ISAproject.repository.RegisteredUserRepository;
import com.example.ISAproject.repository.StuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StuffService
{
    @Autowired
    private StuffRepository stuffRepository;

    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    @Autowired
    private DonationTermsRepository donationTermsRepository;

    @Autowired
    private  DonationTermsService donationTermsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StuffService stuffService;

    public List<Stuff> findAll() {return  this.stuffRepository.findAll();}






    public Stuff findById(Long id)
    {
        Optional<Stuff> opt=this.stuffRepository.findById(id);
        if(!opt.isPresent())
        {
            return null;
        }
        return opt.get();
    }

    //Pretraga Zaposlenih Po Centru kojem pripada
    public List<Stuff> FindStuffByCenter(Long id)
    {
        List<Stuff> all_stuffs = stuffRepository.findAll();
        List<Stuff> finded_stuffs = new ArrayList<>();

        for(Stuff s: all_stuffs)
        {
            if(s.getBloodCenter().getId() == id)
            {
                finded_stuffs.add(s);
            }
        }

        return  finded_stuffs;
    }

    //Izmena Podataka Za administratore centra i medicinsko osoblje
    public Stuff UpdateStuff(Stuff s)
    {
        Stuff stuff = stuffRepository.getById(s.getId());

        stuff.setFirstName(s.getFirstName());
        stuff.setLastName(s.getLastName());
        //stuff.setUsername(s.getUsername());
        stuff.setEmail(s.getEmail());
        stuff.setState(s.getState());
        stuff.setCity(s.getCity());
        stuff.setAdress(s.getAdress());
        stuff.setMobile(s.getMobile());
        stuff.setProfession(s.getProfession());
        stuff.setOrganizationInformation(s.getOrganizationInformation());

        //stuff.setPassword(passwordEncoder.encode(s.getPassword()));
        //String newPasswordHash=passwordEncoder.encode(s.getPassword());
        //stuff.setPassword(newPasswordHash);

        return this.stuffRepository.save(stuff);


    }

    //Izmena lozinke
    public Stuff changePassword(Long id, PasswordChangeDTO dto)
    {
        //Stuff stuff = this.stuffRepository.getById(id);

        Stuff stuff = this.stuffService.findById(id);

        String newPasswordHash = passwordEncoder.encode(dto.getNewPassword());
        stuff.setPassword(newPasswordHash);
        stuff.setFirstLogin(false);
        stuffRepository.save(stuff);
        return stuff;
    }

    public Stuff changeOnlyPassword(Stuff s)
    {
        Stuff stuff = stuffRepository.getById(s.getId());

        String newPasswordHash = passwordEncoder.encode(s.getPassword());
        stuff.setPassword(newPasswordHash);
        stuffRepository.save(stuff);
        return  stuff;
    }






    public Stuff save(Stuff newStuff) {
        return this.stuffRepository.save(newStuff);
    }

    //Student3 Funkcionalnost -- Dodeljivanje negativnog boda ako se korisnik ne pojavi na pregledu
    public RegisteredUser addNegativePoint(Long id)
    {
        DonationTerms donationTerms = donationTermsRepository.getById(id);
        RegisteredUser registeredUser = donationTerms.getRegisteredUser();

        if(donationTerms.isRegisteredUserCome() == false)
        {
            registeredUser.setPoints(registeredUser.getPoints() + 1);
        }

        registeredUserRepository.save(registeredUser);

        return registeredUser;
    }


    //Sa povratnom vrednoscu
    public DonationTerms addPenalty(DonationTerms dt)
    {
        DonationTerms donationTerms = donationTermsService.findByTermsId(dt.getId());
        RegisteredUser registeredUser = donationTerms.getRegisteredUser();

        /*if(donationTerms.isRegisteredUserCome() == false && !Objects.equals(registeredUser.getBenefits(), "Redovan+"))
        {
            registeredUser.setBenefits("Redovan+");
            registeredUser.setPoints(registeredUser.getPoints() + 1);
        }*/

        if(donationTerms.isRegisteredUserCome() == false && donationTerms.isUser_got_penalty() == false)
        {
            donationTerms.setUser_got_penalty(true);
            registeredUser.setPoints(registeredUser.getPoints() + 1);
            System.out.println("Stavio sam penal NA TRUE");
        }



        registeredUserRepository.save(registeredUser);

        return donationTerms;
    }

    //Provera Da li se Korisnik Pojavio ili nije na pregledu
    public DonationTerms UpdateExam(DonationTerms dt)
    {
        DonationTerms donationTerms = donationTermsService.findByTermsId(dt.getId());
        RegisteredUser registeredUser = donationTerms.getRegisteredUser();

        if (donationTerms.isRegisteredUserCome() == true)
        {
            donationTerms.setRegisteredUserCome(false);
            donationTerms.setFreeTerm(true);
        }
        else if(donationTerms.isRegisteredUserCome() == false)
        {
           /* if(Objects.equals(registeredUser.getBenefits(), "Redovan+"))
            {
                registeredUser.setPoints(registeredUser.getPoints() - 1);
                registeredUser.setBenefits("Redovan");
                donationTerms.setRegisteredUserCome(true);
                donationTerms.setFreeTerm(true);
            }*/
            if(donationTerms.isUser_got_penalty() == true)
            {
                registeredUser.setPoints(registeredUser.getPoints() - 1);
                donationTerms.setUser_got_penalty(false);
                donationTerms.setRegisteredUserCome(true);
                donationTerms.setFreeTerm(true);
            }
            else
            {
                donationTerms.setRegisteredUserCome(true);
                donationTerms.setFreeTerm(true);
            }


        }
        registeredUserRepository.save(registeredUser);
        donationTermsRepository.save(donationTerms);

        return  donationTerms;

    }






}
