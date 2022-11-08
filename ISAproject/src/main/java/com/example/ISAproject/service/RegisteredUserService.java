package com.example.ISAproject.service;


import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.model.User;
import com.example.ISAproject.repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisteredUserService {
    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    public List<RegisteredUser> findAll() { return this.registeredUserRepository.findAll();}


}
