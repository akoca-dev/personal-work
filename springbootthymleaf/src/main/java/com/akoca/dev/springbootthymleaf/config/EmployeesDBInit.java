package com.akoca.dev.springbootthymleaf.config;

import com.akoca.dev.springbootthymleaf.entity.Employee;
import com.akoca.dev.springbootthymleaf.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class EmployeesDBInit {

    private final EmployeeService employeeService;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        List<Employee> employees = List.of(
                new Employee(1L, "Akoca", "Koca", "akoca@mail.com"),
                new Employee(2L, "Hkoca", "Koca", "hkoca@mail.com"),
                new Employee(3L, "Yuzun", "Uzun", "yuzun@mail.com")
        );

        employees.forEach(employeeService::save);
    }
}