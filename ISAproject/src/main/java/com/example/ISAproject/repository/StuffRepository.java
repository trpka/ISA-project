package com.example.ISAproject.repository;

import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.model.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffRepository extends  JpaRepository<Stuff, Long>
{

}


