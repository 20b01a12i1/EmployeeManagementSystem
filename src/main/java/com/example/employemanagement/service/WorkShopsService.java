package com.example.employemanagement.service;

import java.util.List;

import com.example.employemanagement.model.WorkShops;

public interface WorkShopsService {

	public void createWorkShop(WorkShops workshop);
	public void delWorkShop(String id);
	public List<WorkShops> getAllWorkShops();
	public String getEmpById(String id);
}
