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


    public List<BloodCenter> findByAddress(String address){
		return this.bloodCenterRepository.findByAddress(address);
	}
    
    public List<BloodCenter> findByCenterName(String name){
		return this.bloodCenterRepository.findByCenterName(name);
	}

    public List<BloodCenter> sortByName(){
        return this.bloodCenterRepository.findByOrderByCenterName();
    }
    public List<BloodCenter> sortByGrade(){
        return this.bloodCenterRepository.findByOrderByAverageGradeCentreDesc();
    }
    public List<BloodCenter> sortByCity(){
        return this.bloodCenterRepository.findByOrderByCity();
    }
    
//    public List<BloodCenter> sortByAverageGrade(){
//		return this.bloodCenterRepository.sortByGrade();
//	}
//    
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
