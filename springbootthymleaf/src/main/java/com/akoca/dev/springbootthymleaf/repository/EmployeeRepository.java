package com.akoca.dev.springbootthymleaf.repository;

import com.akoca.dev.springbootthymleaf.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e ORDER BY e.lastName")
    List<Employee> findAllOrderByLastNameAsc();
}
