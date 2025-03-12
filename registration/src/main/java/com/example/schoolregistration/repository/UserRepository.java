package com.example.schoolregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schoolregistration.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
