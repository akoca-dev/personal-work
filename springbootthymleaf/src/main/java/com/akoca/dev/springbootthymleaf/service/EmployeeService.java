package com.akoca.dev.springbootthymleaf.service;

import com.akoca.dev.springbootthymleaf.entity.Employee;

import java.util.List;

public interface EmployeeService {

	List<Employee> findAll();

	List<Employee> findAllSortByLastName();
	
	Employee findById(Long theId);
	
	void save(Employee theEmployee);
	
	void deleteById(Long theId);
	
}
