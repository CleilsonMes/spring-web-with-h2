package com.cleilsonmes.webh2db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cleilsonmes.webh2db.dao.EmployeeRepository;
import com.cleilsonmes.webh2db.dao.ProjectRepository;
import com.cleilsonmes.webh2db.dto.ChartData;
import com.cleilsonmes.webh2db.dto.EmployeeProject;
import com.cleilsonmes.webh2db.entities.Employee;
import com.cleilsonmes.webh2db.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	
	// Pesquisar depois sobre essas injeções de dependencia.

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayHome(Model model) throws JsonProcessingException {

		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		
		List<ChartData> chartDatas = proRepo.getProjectStatus();
		// Converter o objeto em json para usar no javascript chart
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonStr = objectMapper.writeValueAsString(chartDatas);
		model.addAttribute("projectStatusCnt", jsonStr);
		
		
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employees", employees);
		
		List<EmployeeProject> empProjCount = empRepo.employeeProjects();
		model.addAttribute("empProjCount", empProjCount);
		
		return "main/home";
	}
	
}
