
package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);
    Page<EmployeeDTO> getAllEmployees(Pageable pageable);
    Page<EmployeeDTO> searchEmployees(String query, Pageable pageable);
}

