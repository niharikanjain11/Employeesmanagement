//package com.example.employeemanagement.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.Optional;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//
//import com.example.employeemanagement.dto.EmployeeDTO;
//import com.example.employeemanagement.entity.Employee;
//import com.example.employeemanagement.exception.ResourceNotFoundException;
//import com.example.employeemanagement.mapper.EmployeeMapper;
//import com.example.employeemanagement.repository.EmployeeRepository;
//import com.example.employeemanagement.serviceimpl.EmployeeServiceImpl;
//
//class EmployeeServiceTest {
//
//    private Object Mockito;
//	private final EmployeeRepository employeeRepository = ((Object) Mockito).mock(EmployeeRepository.class);
//    private final EmployeeMapper mapper = Mockito.mock(EmployeeMapper.class);
//    private final EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository, mapper);
//
//    @Test
//    void testGetEmployeeById_NotFound() {
//        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.empty());
//        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
//            employeeService.getEmployeeById(1L);
//        });
//        assertTrue(exception.getMessage().contains("Employee not found"));
//    }
//
//    @Test
//    void testGetAllEmployees() {
//        Employee employee = new Employee();
//        employee.setId(1L);
//        employee.setName("John Doe");
//        employee.setDepartment("IT");
//        employee.setAge(30);
//        employee.setEmail("john@example.com");
//        employee.setSalary(new BigDecimal("50000.00"));
//
//        Page<Employee> page = new PageImpl<>(Arrays.asList(employee));
//        Mockito.when(employeeRepository.findAll(any(PageRequest.class))).thenReturn(page);
//        // Assume mapper works as expected
//        Mockito.when(mapper.toDTO(any(Employee.class))).thenReturn(new EmployeeDTO());
//
//        Page<EmployeeDTO> result = employeeService.getAllEmployees(PageRequest.of(0, 10));
//        assertEquals(1, result.getTotalElements());
//    }
//}