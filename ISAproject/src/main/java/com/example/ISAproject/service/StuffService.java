package com.example.ISAproject.service;

import com.example.ISAproject.model.Stuff;
import com.example.ISAproject.repository.StuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StuffService
{
    @Autowired
    private StuffRepository stuffRepository;

    public List<Stuff> findAll() {return  this.stuffRepository.findAll();}

    public Optional<Stuff> findById(Long id)
    {
        return  this.stuffRepository.findById(id);
    }





}
