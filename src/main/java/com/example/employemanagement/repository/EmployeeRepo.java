package com.example.employemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employemanagement.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
