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


    
    public List<BloodCenter> findByCenterName(String name){
		return this.bloodCenterRepository.findByCenterName(name);
	}

    public List<BloodCenter> findCenterByCity(String city){
		return this.bloodCenterRepository.findByCity(city);
	}
    
    public List<BloodCenter> findByAddress(String address){
		return this.bloodCenterRepository.findByAddress(address);
	}
    
    public List<BloodCenter> findByAverageGradeCentre(Long averageGradeCentre){
		return this.bloodCenterRepository.findByAverageGradeCentre(averageGradeCentre);
	}

    
	  public List<BloodCenter> findByAddressAndAverageGradeCentre(String address, Long averageGradeCentre){
		  return this.bloodCenterRepository.findByAddressAndAverageGradeCentre(address,averageGradeCentre);
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
    

    public BloodCenter findById(Long id)
    {
        Optional<BloodCenter> opt=this.bloodCenterRepository.findById(id);
        if(!opt.isPresent())
        {
            return null;
        }
        return opt.get();
    }

    public BloodCenter UpdateCenter(BloodCenter bc)
    {
        BloodCenter bloodCenter = bloodCenterRepository.getById(bc.getId());

        bloodCenter.setCenterName(bc.getCenterName());
        bloodCenter.setAddress(bc.getAddress());
        bloodCenter.setCity(bc.getCity());
        bloodCenter.setAverageGradeCentre(bc.getAverageGradeCentre());
        bloodCenter.setDescription(bc.getDescription());
        bloodCenter.setBloodA(bc.getBloodA());
        bloodCenter.setBloodB(bc.getBloodB());
        bloodCenter.setBloodAB(bc.getBloodAB());
        bloodCenter.setBloodO(bc.getBloodO());

        return  this.bloodCenterRepository.save(bloodCenter);
    }

    public BloodCenter save(BloodCenter bloodCenter)
    {
        return  this.bloodCenterRepository.save(bloodCenter);
    }

    public void delete(BloodCenter bloodCenter)
    {
        this.bloodCenterRepository.delete(bloodCenter);
    }

    public List<BloodCenter> findByUsernameContaining(String namePart) {
        return bloodCenterRepository.findByCenterNameContaining(namePart);
    }


}
