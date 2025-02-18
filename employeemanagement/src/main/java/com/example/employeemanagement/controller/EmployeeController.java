package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Create an employee")
    @PostMapping
    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @Operation(summary = "Get an employee by id")
    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @Operation(summary = "Update an employee")
    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @Operation(summary = "Delete an employee (ADMIN only)")
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @Operation(summary = "Get all employees with pagination and sorting")
    @GetMapping
    public Page<EmployeeDTO> getAllEmployees(Pageable pageable) {
        return employeeService.getAllEmployees(pageable);
    }

    @Operation(summary = "Search employees by name or department")
    @GetMapping("/search")
    public Page<EmployeeDTO> searchEmployees(@RequestParam("query") String query, Pageable pageable) {
        return employeeService.searchEmployees(query, pageable);
    }
}
