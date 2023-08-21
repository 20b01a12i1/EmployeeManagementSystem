package com.example.employemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employemanagement.model.Skills;

public interface SkillsRepo extends JpaRepository<Skills, Long> {
	
}
