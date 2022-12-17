package com.example.ISAproject.repository;


import com.example.ISAproject.model.StuffSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffSurveyRepository extends JpaRepository<StuffSurvey,Long>
{

}
