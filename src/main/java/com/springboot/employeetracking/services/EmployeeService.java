package com.springboot.employeetracking.services;

import java.util.List;

import com.springboot.employeetracking.models.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(Long id);
	void deleteEmployeeById(Long id);
}
