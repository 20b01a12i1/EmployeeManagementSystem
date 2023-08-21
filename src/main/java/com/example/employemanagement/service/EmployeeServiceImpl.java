package com.example.employemanagement.service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employemanagement.model.Employee;
import com.example.employemanagement.model.User;
import com.example.employemanagement.repository.EmployeeRepo;
import com.example.employemanagement.repository.UserRepo;

@Service
public class EmployeeServiceImpl implements EmpService<Employee> {
	
	@Autowired
	EmployeeRepo emprepo;
	@Autowired
	UserRepo userrepo;

	@Override
	public void createEmp(Employee emp) {
		// TODO Auto-generated method stub
		if(Objects.nonNull(emp)) {
			emprepo.save(emp);
		}
		
	}

	@Override
	public void delEmp(String id) {
		// TODO Auto-generated method stub
		if(Objects.nonNull(id)) {
			emprepo.deleteById(Long.parseLong(id));
		}
		

	}

	@Override
	public Employee getEmpByid(String id) {
		// TODO Auto-generated method stub
		Employee emp=null;
		if(Objects.nonNull(id)) {
			Optional<Employee> optionalEmp=emprepo.findById(Long.parseLong(id));
			
			if(optionalEmp.isPresent()) {
				emp=optionalEmp.get();
			}
			else {
				throw new RuntimeException("Employee not found with the id:"+id);
			}
			
		}
		return emp;
		
	}

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		return emprepo.findAll();
	}

	@Override
	public void update(Employee E) {
		emprepo.save(E);
	}

	@Override
	public User getUserByid(String id) {

		if(userrepo.findById(Long.parseLong(id)).isPresent())
			return userrepo.findById(Long.parseLong(id)).get();
		return null;
	}

}
