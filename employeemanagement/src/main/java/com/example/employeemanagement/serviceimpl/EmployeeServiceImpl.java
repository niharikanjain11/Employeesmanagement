
package com.example.employeemanagement.serviceimpl;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.exception.ResourceNotFoundException;
import com.example.employeemanagement.mapper.EmployeeMapper;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapper.toEntity(employeeDTO);
        // Set createdAt, etc. (if not using auditing)
        Employee saved = employeeRepository.save(employee);
        return mapper.toDTO(saved);
    }

    @Override
    @Cacheable(value = "employees", key = "#id")
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return mapper.toDTO(employee);
    }

    @Override
    @CacheEvict(value = "employees", key = "#id")
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existing = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        // Update fields
        existing.setName(employeeDTO.getName());
        existing.setDepartment(employeeDTO.getDepartment());
        existing.setAge(employeeDTO.getAge());
        existing.setEmail(employeeDTO.getEmail());
        existing.setSalary(employeeDTO.getSalary());
        Employee updated = employeeRepository.save(existing);
        return mapper.toDTO(updated);
    }

    @Override
    @CacheEvict(value = "employees", key = "#id")
    public void deleteEmployee(Long id) {
        Employee existing = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(existing);
    }

    @Override
    public Page<EmployeeDTO> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable)
                .map(mapper::toDTO);
    }

    @Override
    public Page<EmployeeDTO> searchEmployees(String query, Pageable pageable) {
        return employeeRepository
                .findByNameContainingIgnoreCaseOrDepartmentContainingIgnoreCase(query, query, pageable)
                .map(mapper::toDTO);
    }
}
