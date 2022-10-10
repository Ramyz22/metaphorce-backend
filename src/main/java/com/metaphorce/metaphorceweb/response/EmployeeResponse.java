package com.metaphorce.metaphorceweb.response;

import java.util.List;

import com.metaphorce.metaphorceweb.model.Employee;

import lombok.Data;

@Data
public class EmployeeResponse {

	List<Employee> employee; 
}
