package com.example.employemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employemanagement.model.Employee;
import com.example.employemanagement.model.User;


public interface EmpService<E> {

	public void createEmp(Employee emp);
	public void delEmp(String id);
	public Employee getEmpByid(String id);
	public List<Employee> getAllEmp();
	public void update(Employee E);
	public User getUserByid(String id);
}
