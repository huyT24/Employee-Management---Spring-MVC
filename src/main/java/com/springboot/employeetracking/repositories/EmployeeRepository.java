package com.springboot.employeetracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.employeetracking.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
