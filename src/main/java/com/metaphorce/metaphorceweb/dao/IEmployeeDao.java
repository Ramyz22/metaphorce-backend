package com.metaphorce.metaphorceweb.dao;

import org.springframework.data.repository.CrudRepository;

import com.metaphorce.metaphorceweb.model.Employee;

public interface IEmployeeDao extends CrudRepository <Employee, Long>{

	
}
