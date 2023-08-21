package com.example.employemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.employemanagement.model.Employee;
import com.example.employemanagement.model.Skills;
import com.example.employemanagement.service.SkillsServiceImpl;

@Controller
public class SkillsController {
	
	@Autowired
	SkillsServiceImpl skillsserviceimpl;
	
	@GetMapping("/addskill/{id}")
	public String addEmp(@PathVariable String id,Model model) {
		Skills skill = new Skills();
		skill.setId(Long.parseLong(id));
		model.addAttribute("skill",skill);
		return "addSkill";
	}
	
	@PostMapping("/saveskill")
	public String saveEmp(@ModelAttribute("skill") Skills skill,Model model) {
		skillsserviceimpl.createSkill(skill);
		return "redirect:/getempdetails/"+skill.getId();
	}
	
	@GetMapping("/delskill/{id}")
	public String delEmp(@PathVariable String id){
		String s=skillsserviceimpl.getEmpId(id);
		skillsserviceimpl.delSkill(id);
		return "redirect:/getempdetails/"+s;
	}

}
