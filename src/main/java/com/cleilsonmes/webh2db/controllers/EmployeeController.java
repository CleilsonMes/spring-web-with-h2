package com.cleilsonmes.webh2db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cleilsonmes.webh2db.dao.EmployeeRepository;
import com.cleilsonmes.webh2db.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayEmployees(Model model) {
	
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employees", employees);
		
		return "employees/list-employees";
	}	
	
	@GetMapping("/new")
	public String displayForm(Model model) {
		
		Employee employee = new Employee();
		
		// Binding th:object="${employee}" no html
		model.addAttribute("employee", employee);
		
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createForm(Employee employee, Model model) {
		// saving to the database...
		empRepo.save(employee);
		
		// user redirect para previnir o duplo submit do botão
		return "redirect:/employees/new";
	}
}
