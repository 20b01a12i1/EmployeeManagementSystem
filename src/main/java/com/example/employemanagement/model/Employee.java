package com.example.employemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {
	
	@Id
	long id;
	String name;
	String salary;
	int experiance;

}
