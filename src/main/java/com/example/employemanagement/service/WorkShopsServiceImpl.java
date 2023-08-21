package com.example.employemanagement.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employemanagement.model.WorkShops;
import com.example.employemanagement.repository.WorkshopRepo;

@Service
public class WorkShopsServiceImpl implements WorkShopsService {
	
	@Autowired
	WorkshopRepo workshoprepo;

	@Override
	public void createWorkShop(WorkShops workshop) {
		// TODO Auto-generated method stub
		if(Objects.nonNull(workshop)) {
			workshoprepo.save(workshop);
		}
		
	}

	@Override
	public void delWorkShop(String id) {
		// TODO Auto-generated method stub
		if(Objects.nonNull(id)) {
			workshoprepo.deleteById(Long.parseLong(id));
		}
		
	}

	@Override
	public List<WorkShops> getAllWorkShops() {
		// TODO Auto-generated method stub
		return workshoprepo.findAll();
	}

	@Override
	public String getEmpById(String id) {
		// TODO Auto-generated method stub
		WorkShops s=workshoprepo.findById(Long.parseLong(id)).get();
		return Long.toString(s.getId());
	}

}
