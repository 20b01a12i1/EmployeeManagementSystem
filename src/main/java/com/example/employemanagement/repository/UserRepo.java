package com.example.employemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employemanagement.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
