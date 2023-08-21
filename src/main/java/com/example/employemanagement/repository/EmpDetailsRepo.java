package com.example.employemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employemanagement.model.Empdetails;

public interface EmpDetailsRepo extends JpaRepository<Empdetails, Long> {
//	void deleteById(long id);
}
