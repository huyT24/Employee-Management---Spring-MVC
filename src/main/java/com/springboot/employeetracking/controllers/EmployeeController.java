package com.springboot.employeetracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.employeetracking.models.Employee;
import com.springboot.employeetracking.serviceImpls.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@GetMapping("/")
	public String viewHomepage(Model model) {
		employeeServiceImpl.getAllEmployees().forEach(employee -> System.out.println(employee.getEmail()));
		model.addAttribute("listEmployees", employeeServiceImpl.getAllEmployees());
		return "index";
	}

	@GetMapping("/addEmployee")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeServiceImpl.saveEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Employee updatEmployee = employeeServiceImpl.getEmployeeById(id);

		model.addAttribute("employee", updatEmployee);
		return "updateEmployee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		this.employeeServiceImpl.deleteEmployeeById(id);
		return "redirect:/";
	}
}
