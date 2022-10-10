package com.metaphorce.metaphorceweb.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table (name = "contract")
public class Contract implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9036853534258753722L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date_from;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date_to;
	
	private double salary_per_day;
	
	private boolean is_active; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date_created;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handle"})
	private Employee employee; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handle"})
	private ContractType contracttype; 
	
	
}
