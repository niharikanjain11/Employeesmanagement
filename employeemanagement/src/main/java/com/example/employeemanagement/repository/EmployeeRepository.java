
package com.example.employeemanagement.repository;

import com.example.employeemanagement.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Search employees by name or department (using Spring Data query method)
    Page<Employee> findByNameContainingIgnoreCaseOrDepartmentContainingIgnoreCase(String name, String department, Pageable pageable);
}
