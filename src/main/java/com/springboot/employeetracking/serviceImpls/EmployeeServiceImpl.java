package com.springboot.employeetracking.serviceImpls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employeetracking.models.Employee;
import com.springboot.employeetracking.repositories.EmployeeRepository;
import com.springboot.employeetracking.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {	
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		Employee em = null;
		if (employee.isPresent()) {
			em = employee.get();
		} else {
			throw new RuntimeException("Employee not found for id :: " + id);
		}
		return em;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		this.employeeRepository.deleteById(id);
	}

}
