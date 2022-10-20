package com.example.ISAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ISAproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	 User findByUsername(String username);
}
