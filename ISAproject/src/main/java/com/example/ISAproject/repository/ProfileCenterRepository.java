package com.example.ISAproject.repository;

import com.example.ISAproject.model.ProfileCenter;
import com.example.ISAproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface ProfileCenterRepository extends JpaRepository<ProfileCenter, Long>
{
   // List<ProfileCenter> findCentersByName(String name);

    ProfileCenter findByCenterName(String centerName);
}
