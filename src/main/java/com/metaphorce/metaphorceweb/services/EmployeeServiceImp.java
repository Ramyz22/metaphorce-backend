package com.metaphorce.metaphorceweb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metaphorce.metaphorceweb.dao.IEmployeeDao;
import com.metaphorce.metaphorceweb.model.Employee;
import com.metaphorce.metaphorceweb.response.EmployeeResponseRest;

@Service
public class EmployeeServiceImp implements IEmployeeService{

	@Autowired
	private IEmployeeDao employeeDao;
	
	@Transactional
	public ResponseEntity<EmployeeResponseRest> save(Employee employee) {
		
		EmployeeResponseRest response = new EmployeeResponseRest();
		List <Employee> list = new ArrayList<>();
		
		try {
			Employee employeeSaved = employeeDao.save(employee);
			if (employeeSaved != null) {
				list.add(employeeSaved);
				response.getEmployee().setEmployee(list);
				response.setMetadata("Response ok ", "00", "Employee Saved");
				
			} else {
				response.setMetadata("Response  No ok", "-1", "Employee Don't saved!");
				return new ResponseEntity<EmployeeResponseRest>(response, HttpStatus.BAD_REQUEST);

			}
			
		} catch (Exception e) {
			response.setMetadata("Response No ok", "-1", "Error to try save Employee!");
			e.getStackTrace();
			return new ResponseEntity<EmployeeResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return new ResponseEntity<EmployeeResponseRest>(response, HttpStatus.OK);
		
	}

	@Override
	@Transactional
	public ResponseEntity<EmployeeResponseRest> update(Employee employee, Long id) {

		EmployeeResponseRest response = new EmployeeResponseRest();
		List <Employee> list = new ArrayList<>();
		
		try {
			Optional <Employee> employeeSearch = employeeDao.findById(id);
			if (employeeSearch.isPresent()) {
				//Update employee
				employeeSearch.get().setTaxidnumber(employee.getTaxidnumber());
				employeeSearch.get().setName(employee.getName());
				employeeSearch.get().setLastname(employee.getLastname());
				employeeSearch.get().setBirthday(employee.getBirthday());
				employeeSearch.get().setEmail(employee.getEmail());
				employeeSearch.get().setCellphone(employee.getCellphone());
				employeeSearch.get().set_active(employee.is_active());
				
				Employee employeeToUpdate = employeeDao.save(employeeSearch.get());
					if (employeeToUpdate != null) {
						list.add(employeeToUpdate);
						response.getEmployee().setEmployee(list);
						response.setMetadata("Response ok ", "00", "Employee Updated");
					} else {
						
						response.setMetadata("Response No OK", "-1", "Employee Don't updated!");
						return new ResponseEntity<EmployeeResponseRest>(response, HttpStatus.BAD_REQUEST);

					}
				
				
			} else {
				response.setMetadata("Response  No ok", "-1", "Employee Don't Found!");
				return new ResponseEntity<EmployeeResponseRest>(response, HttpStatus.NOT_FOUND);

			}
			
		} catch (Exception e) {
			response.setMetadata("Response No ok", "-1", "Error to try update Employee!");
			e.getStackTrace();
			return new ResponseEntity<EmployeeResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return new ResponseEntity<EmployeeResponseRest>(response, HttpStatus.OK);
		
	}

	
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<EmployeeResponseRest> getListEmployee() {
		
		EmployeeResponseRest response = new EmployeeResponseRest();
		
		try {
			List <Employee> list = (List<Employee>) employeeDao.findAll();
			response.getEmployee().setEmployee(list);
			response.setMetadata("Response ok ", "00", "Successful Response!");
			
			
		} catch (Exception e) {
			response.setMetadata("Response No ok", "-1", "Error Response!");
			e.getStackTrace();
			return new ResponseEntity<EmployeeResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return new ResponseEntity<EmployeeResponseRest>(response, HttpStatus.OK);

	}

}
