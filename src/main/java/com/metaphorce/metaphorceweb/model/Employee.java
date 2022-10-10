package com.metaphorce.metaphorceweb.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table (name = "employee")
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8601047552067215340L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String taxidnumber;
	private String name; 
	private String lastname;
	
	@Temporal(TemporalType.DATE)
	private Calendar birthday;
	
	private String email; 
	private String cellphone;
	private boolean is_active; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date_created; 
	
}
