package com.example.employemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.employemanagement.model.Skills;
import com.example.employemanagement.model.WorkShops;
import com.example.employemanagement.service.WorkShopsServiceImpl;

@Controller
public class WorkShopsController {
	
	@Autowired
	WorkShopsServiceImpl workshopserviceimpl;
	
	@GetMapping("/addworkshop/{id}")
	public String addWorkShop(@PathVariable String id,Model model) {
		WorkShops workshop = new WorkShops();
		workshop.setId(Long.parseLong(id));
		model.addAttribute("workshop",workshop);
		return "addWorkShop";
	}
	
	@PostMapping("/saveworkshop")
	public String saveWorkShop(@ModelAttribute("workshop") WorkShops workshop,Model model) {
		System.out.println(workshop);
		workshopserviceimpl.createWorkShop(workshop);
		return "redirect:/getempdetails/"+workshop.getId();
	}
	
	@GetMapping("/delworkshop/{id}")
	public String delEmp(@PathVariable String id){
		String s=workshopserviceimpl.getEmpById(id);
		workshopserviceimpl.delWorkShop(id);
		return "redirect:/getempdetails/"+s;
	}

}
