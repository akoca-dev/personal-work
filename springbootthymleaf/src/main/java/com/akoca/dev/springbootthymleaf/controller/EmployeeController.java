package com.akoca.dev.springbootthymleaf.controller;

import com.akoca.dev.springbootthymleaf.entity.Employee;
import com.akoca.dev.springbootthymleaf.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmployess(Model model) {

        List<Employee> employees = employeeService.findAllSortByLastName();

        model.addAttribute("employeeList", employees);

        return "employees/employees";
    }

    @GetMapping("/new-employee")
    public String newEmployee(Model model) {

        Employee newEmployee = new Employee();

        model.addAttribute("newEmployee", newEmployee);

        return "employees/new-employee-form";
    }

    @GetMapping("/update-employee")
    public String updateEmployee(@RequestParam("employeeId") Long employeeId, Model model) {

        Employee currentEmployee = employeeService.findById(employeeId);

        model.addAttribute("currentEmployee", currentEmployee);

        return "employees/update-employee-form";
    }

    @GetMapping("/delete-employee")
    public String deleteEmployee(@RequestParam("employeeId") Long employeeId) {

        employeeService.deleteById(employeeId);

        return "redirect:/employees/list";
    }

    @PostMapping("/save-employee")
    public String saveNewEmployee(@ModelAttribute("newEmployee") Employee newEmployee) {

        employeeService.save(newEmployee);

        return "redirect:/employees/list";
    }
}
