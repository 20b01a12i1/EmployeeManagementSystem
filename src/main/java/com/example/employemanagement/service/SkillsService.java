package com.example.employemanagement.service;

import java.util.List;

import com.example.employemanagement.model.Skills;



public interface SkillsService {
	public void createSkill(Skills skill);
	public void delSkill(String id);
	public List<Skills> getAllSkill();
	public String getEmpId(String id);
	
}
