package com.example.employemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employemanagement.model.Empdetails;


public interface EmpDetailsService {
	public void createEmp(Empdetails emp);
	public void delEmp(String id);
	public Empdetails getEmpByid(String id);

}
