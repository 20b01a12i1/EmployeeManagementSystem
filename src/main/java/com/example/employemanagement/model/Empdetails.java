package com.example.employemanagement.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Empdetails {
	
	@Id
	long id;
	String name;
	String salary;
	int experiance;
	String dob;
	String email;
	String phno;
	String designation;
	String branch;
	String address;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name="id")
	List<WorkShops> workshop;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name="id")
	List<Skills> skill;
	


}
