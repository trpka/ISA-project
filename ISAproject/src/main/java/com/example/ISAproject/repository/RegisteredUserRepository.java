package com.example.ISAproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ISAproject.model.BloodCenter;

import com.example.ISAproject.model.RegisteredUser;
import java.util.List;

@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long>
{
  




