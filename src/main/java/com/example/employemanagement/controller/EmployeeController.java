package com.example.employemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employemanagement.model.Empdetails;
import com.example.employemanagement.model.Employee;
import com.example.employemanagement.model.User;
import com.example.employemanagement.service.EmpDetailsServiceImpl;
import com.example.employemanagement.service.EmployeeServiceImpl;
import com.example.employemanagement.service.SkillsServiceImpl;
import com.example.employemanagement.service.WorkShopsServiceImpl;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl empservice;
	@Autowired
	EmpDetailsServiceImpl empdetailsimpl;
	@Autowired
	SkillsServiceImpl skillsserviceimpl;
	@Autowired
	WorkShopsServiceImpl workshopserviceimpl;
	
	@RequestMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@PostMapping("/login")
	public String checkUser(HttpSession session,@ModelAttribute(name="loginForm") User user,Model model) {
		String uname = Long.toString(user.getId());
		String pass = user.getPassword();
		User dbuser=empservice.getUserByid(uname);
		if(dbuser!=null && dbuser.getPassword().equals(pass)) {
		   model.addAttribute("id", uname);
		   model.addAttribute("password", pass);
		   session.setAttribute("user", uname);
//		   System.out.println(session.getAttribute("user"));
		   return "redirect:/getAll";
		   
		}
		model.addAttribute("error", "Incorrect Username & Password");
		return "index";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
//		System.out.println(session.getAttribute("user"));
		session.removeAttribute("user");
		session.invalidate();
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmp(Model model) {
		Employee emp = new Employee();
		model.addAttribute(emp);
		return "addEmp";
	}
	
	@PostMapping("/saveemp")
	public String saveEmp(@ModelAttribute("employee") Employee employee,Model model) {
		Empdetails emp=new Empdetails();
		empservice.createEmp(employee);
		emp.setId(employee.getId());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		emp.setExperiance(employee.getExperiance());
		model.addAttribute("employee",emp);
		return "addDetails";
	}
	
	@GetMapping("/get/{id}")
	public String findEmp(@PathVariable String id,Model model){
		model.addAttribute("employee",empservice.getEmpByid(id));
		model.addAttribute("allskills",skillsserviceimpl.getAllSkill());
		return "view";
	}
	
	
	@GetMapping("/getAll")
	public String getallEmp(Model model){
		model.addAttribute("allemp", empservice.getAllEmp());
		return "table";
	}
	
	@GetMapping("/update/{id}")
	public String updateCompleted(@PathVariable String id,Model model) {
		Employee emp = empservice.getEmpByid(id);
		model.addAttribute(emp);
		return "update";
	}
	
	@GetMapping("/del/{id}")
	public String delEmp(@PathVariable String id){
		empservice.delEmp(id);
		empdetailsimpl.delEmp(id);
//		skillsserviceimpl.delSkillsByUserId(id);
		return "redirect:/getAll";
	}
}
