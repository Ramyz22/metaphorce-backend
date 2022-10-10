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
@Table(name = "contracttype")
public class ContractType implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8663598988223523619L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name; 
	private String description; 
	private boolean is_active;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date_created;
	
}
