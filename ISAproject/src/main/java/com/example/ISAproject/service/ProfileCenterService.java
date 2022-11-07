package com.example.ISAproject.service;

import com.example.ISAproject.model.ProfileCenter;
import com.example.ISAproject.repository.ProfileCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileCenterService
{
    @Autowired
    private ProfileCenterRepository profileCenterRepository;

    public List<ProfileCenter> findAll()
    {
       return this.profileCenterRepository.findAll();
    }

    public ProfileCenter findCenterByName(String name)
    {
        return this.profileCenterRepository.findByCenterName(name);
    }

    public ProfileCenter findById(Long id)
    {
        Optional<ProfileCenter> opt=this.profileCenterRepository.findById(id);
        if(!opt.isPresent())
        {
            return null;
        }
        return opt.get();
    }

    public ProfileCenter save(ProfileCenter profileCenter)
    {
        return  this.profileCenterRepository.save(profileCenter);
    }

    public void delete(ProfileCenter profileCenter)
    {
        this.profileCenterRepository.delete(profileCenter);
    }



}
