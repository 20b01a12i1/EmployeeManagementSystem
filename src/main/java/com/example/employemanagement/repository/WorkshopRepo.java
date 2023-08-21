package com.example.employemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employemanagement.model.WorkShops;

public interface WorkshopRepo extends JpaRepository<WorkShops, Long> {

}
