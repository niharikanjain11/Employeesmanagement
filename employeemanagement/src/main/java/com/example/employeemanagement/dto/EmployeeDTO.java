package com.example.employeemanagement.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Department is mandatory")
    private String department;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    @Email(message = "Email should be valid")
    private String email;

    @DecimalMin(value = "30000.00", message = "Salary must be at least 30000.00")
    private BigDecimal salary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

    
}
