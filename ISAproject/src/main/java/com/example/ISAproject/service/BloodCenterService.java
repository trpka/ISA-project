package com.example.ISAproject.service;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.repository.BloodCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodCenterService
{
    @Autowired
    private BloodCenterRepository bloodCenterRepository;

    public List<BloodCenter> findAll()
    {
       return this.bloodCenterRepository.findAll();
    }

    public BloodCenter findCenterByName(String name)
    {
        return this.bloodCenterRepository.findByCenterName(name);
    }

    public BloodCenter findById(Long id)
    {
        Optional<BloodCenter> opt=this.bloodCenterRepository.findById(id);
        if(!opt.isPresent())
        {
            return null;
        }
        return opt.get();
    }

    public BloodCenter save(BloodCenter bloodCenter)
    {
        return  this.bloodCenterRepository.save(bloodCenter);
    }

    public void delete(BloodCenter bloodCenter)
    {
        this.bloodCenterRepository.delete(bloodCenter);
    }



}
