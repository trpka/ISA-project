package com.example.ISAproject.repository;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodCenterRepository extends JpaRepository<BloodCenter, Long> {
}
