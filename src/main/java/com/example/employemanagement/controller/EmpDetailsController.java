package com.example.employemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.employemanagement.model.Empdetails;
import com.example.employemanagement.model.Employee;
import com.example.employemanagement.service.EmpDetailsServiceImpl;
import com.example.employemanagement.service.SkillsServiceImpl;
import com.example.employemanagement.service.WorkShopsServiceImpl;

@Controller
public class EmpDetailsController {
	
	@Autowired
	EmpDetailsServiceImpl empdetailsimpl;

	
	@PostMapping("/saveempdetails")
	public String saveEmp(@ModelAttribute("emp") Empdetails emp,Model model) {
		empdetailsimpl.createEmp(emp);
		model.addAttribute("employee",emp);
		return "view";
	}
	
	@GetMapping("/getempdetails/{id}")
	public String findEmp(@PathVariable String id,Model model){
		model.addAttribute("employee",empdetailsimpl.getEmpByid(id));
		return "view";
	}
	

}
