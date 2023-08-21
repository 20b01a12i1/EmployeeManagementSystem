package com.example.employemanagement.service;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employemanagement.model.Empdetails;
import com.example.employemanagement.model.Employee;
import com.example.employemanagement.repository.EmpDetailsRepo;

@Service
public class EmpDetailsServiceImpl implements EmpDetailsService {
	
	@Autowired
	EmpDetailsRepo empdetailsrepo;

	@Override
	public void createEmp(Empdetails emp) {
		// TODO Auto-generated method stub
		if(Objects.nonNull(emp)) {
			empdetailsrepo.save(emp);
		}
		
	}

	@Override
	public void delEmp(String id) {
		// TODO Auto-generated method stub
		if(Objects.nonNull(id)) {
			empdetailsrepo.deleteById(Long.parseLong(id));
		}
		
	}

	@Override
	public Empdetails getEmpByid(String id) {
		// TODO Auto-generated method stub
		Empdetails emp=null;
		if(Objects.nonNull(id)) {
			Optional<Empdetails> optionalEmp=empdetailsrepo.findById(Long.parseLong(id));
			
			if(optionalEmp.isPresent()) {
				emp=optionalEmp.get();
			}
			else {
				throw new RuntimeException("Employee not found with the id:"+id);
			}
			
		}
		return emp;

	}

}
