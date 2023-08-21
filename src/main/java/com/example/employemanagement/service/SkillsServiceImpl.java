package com.example.employemanagement.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employemanagement.model.Skills;
import com.example.employemanagement.repository.SkillsRepo;

@Service
public class SkillsServiceImpl implements SkillsService {
	
	@Autowired
	SkillsRepo skillrepo;
	

	@Override
	public void createSkill(Skills skill) {
		// TODO Auto-generated method stub
		if(Objects.nonNull(skill)) {
			skillrepo.save(skill);
		}
		
		
	}

	@Override
	public void delSkill(String sid) {
		// TODO Auto-generated method stub
		if(Objects.nonNull(sid)) {
			skillrepo.deleteById(Long.parseLong(sid));
		}
		
	}

	@Override
	public List<Skills> getAllSkill() {
		// TODO Auto-generated method stub
		return skillrepo.findAll();
	}

	@Override
	public String getEmpId(String id) {
		// TODO Auto-generated method stub
		Skills s=skillrepo.findById(Long.parseLong(id)).get();
		return Long.toString(s.getId());
		
	}

	

}
