package com.example.ISAproject.service;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.Stuff;
import com.example.ISAproject.repository.StuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StuffService
{
    @Autowired
    private StuffRepository stuffRepository;

    public List<Stuff> findAll() {return  this.stuffRepository.findAll();}

    /*public Optional<Stuff> findById(Long id)
    {
        return  this.stuffRepository.findById(id);
    }*/


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
        stuff.setUsername(s.getUsername());
        stuff.setPassword(s.getPassword());
        stuff.setEmail(s.getEmail());
        stuff.setCity(s.getCity());
        stuff.setAdress(s.getAdress());
        stuff.setMobile(s.getMobile());

        return this.stuffRepository.save(stuff);


    }





}
