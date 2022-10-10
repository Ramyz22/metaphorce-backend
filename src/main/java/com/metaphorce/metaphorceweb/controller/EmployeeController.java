package com.metaphorce.metaphorceweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metaphorce.metaphorceweb.model.Employee;
import com.metaphorce.metaphorceweb.response.EmployeeResponseRest;
import com.metaphorce.metaphorceweb.services.IEmployeeService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api/v1")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/employee")
	public ResponseEntity<EmployeeResponseRest> GetEmployee(){
		
		ResponseEntity<EmployeeResponseRest> response = service.getListEmployee();
		
		return response; 
	}
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeResponseRest> SaveEmployee(@RequestBody Employee employee){
		
		ResponseEntity <EmployeeResponseRest> response = service.save(employee);
		
		return response; 
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<EmployeeResponseRest> UpdateEmployee (@RequestBody Employee employee, @PathVariable Long id){
		
		ResponseEntity <EmployeeResponseRest> response = service.update(employee, id);
		
		return response; 
	}
}
