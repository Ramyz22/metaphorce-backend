package com.metaphorce.metaphorceweb.services;

import org.springframework.http.ResponseEntity;

import com.metaphorce.metaphorceweb.model.Employee;
import com.metaphorce.metaphorceweb.response.EmployeeResponseRest;

public interface IEmployeeService {

	public ResponseEntity <EmployeeResponseRest> save(Employee employee);
	public ResponseEntity <EmployeeResponseRest> update(Employee employee, Long id);
	public ResponseEntity <EmployeeResponseRest> getListEmployee();
	
}
