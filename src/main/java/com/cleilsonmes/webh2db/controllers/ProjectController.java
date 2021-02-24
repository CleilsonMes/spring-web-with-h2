package com.cleilsonmes.webh2db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cleilsonmes.webh2db.dao.EmployeeRepository;
import com.cleilsonmes.webh2db.dao.ProjectRepository;
import com.cleilsonmes.webh2db.entities.Employee;
import com.cleilsonmes.webh2db.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayProjects(Model model) {
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		
		return "projects/list-projects";
	}	
	
	@GetMapping("/new")
	public String displayForm(Model model) {
		
		Project project = new Project();
		// Binding th:object="${project}" no html
		model.addAttribute("project", project);
		
		List<Employee> employees = empRepo.findAll(); 
		// Binding th:each = "employee : ${allEmployee}" no html
		model.addAttribute("allEmployee", employees);
		
		return "projects/new-project";
	}
	
	// Metodo 1 - Mapeamento Employee x Project
	/*
	@PostMapping("/save")
	public String createForm(Project project, @RequestParam List<Long> employees,  Model model) {
		// saving to the database...
		proRepo.save(project);
		
		// Salvando os Funcionarios do Projeto que o Usuario Selecionar no Cadastro
		Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);
		
		for (Employee emp : chosenEmployees) {
			emp.setTheProject(project);
			empRepo.save(emp);
		}
		
		// user redirect para previnir o duplo submit do botão
		return "redirect:/projects/new";
	}
	*/
	
	
	// Metodo 2 - Mapeamento Employee x Project
	@PostMapping("/save")
	public String createForm(Project project, Model model) {
		// saving to the database...
		proRepo.save(project);
		
		// user redirect para previnir o duplo submit do botão
		return "redirect:/projects";
	}
	
}
