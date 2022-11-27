package com.example.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.Calendar;

@Repository
public interface CalendarRepository  extends JpaRepository<Calendar, Long> {

}
