package com.example.ISAproject.service;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.repository.BloodCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodCenterService {

    @Autowired
    private BloodCenterRepository bloodCenterRepository;

    public List<BloodCenter> findAll() {
        return this.bloodCenterRepository.findAll();
    }
}
