package com.metaphorce.metaphorceweb.dao;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.metaphorce.metaphorceweb.model.Contract;

public interface IContractDao extends JpaRepository <Contract, Long>{

	
//	@Query("SELECT concat(e.name , e.lastname) as name_employee, e.taxidnumber, e.email, ct.name, c.date_from, c.date_to, c.salary_per_day FROM contract c INNER JOIN employee e ON e.id = c.employee_id INNER JOIN contracttype ct ON  ct.id = c.contracttype_id")
//	
//	List <Contract> listEmployeeContract (
//			@Param ("name_employee") String name_employee,
//			@Param ("taxidnumber") String taxidnumber,
//			@Param ("email") String email,
//			@Param ("name") String name,
//			@Param ("date_from") String date_from,
//			@Param ("date_to") String date_to,
//			@Param ("salary_per_day") double salary_per_day
//			);
	
}
