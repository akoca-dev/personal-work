package com.akoca.dev.springbootthymleaf.service;

import com.akoca.dev.springbootthymleaf.entity.Employee;
import com.akoca.dev.springbootthymleaf.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return StreamSupport
				.stream(employeeRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	@Override
	public List<Employee> findAllSortByLastName() {
		return employeeRepository.findAllOrderByLastNameAsc();
	}

	@Override
	public Employee findById(Long theId) {
		return employeeRepository.findById(theId)
				.orElseThrow(() -> new RuntimeException("Did not find employee id - " + theId));
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(Long theId) {
		employeeRepository.deleteById(theId);
	}

}






