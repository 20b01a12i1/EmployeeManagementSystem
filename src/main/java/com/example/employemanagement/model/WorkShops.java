package com.example.employemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name="workshops")
public class WorkShops {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long wid;
	long id;
	String wname;
	String topic;
	
	
	

}
