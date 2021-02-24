package com.cleilsonmes.webh2db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cleilsonmes.webh2db.dao.EmployeeRepository;
import com.cleilsonmes.webh2db.dao.ProjectRepository;

@SpringBootApplication
public class SpringWebWithH2Application {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	ProjectRepository projRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringWebWithH2Application.class, args);
	}
	
	/* EXPLICAÇÕES:
	 * 
	 * Poderá se Subistituido pelo arquivo data.sql, 
	 * So colocar ele no projeto que roda sozinho.
	 * 
	 * Mas pelo arquivo fica dando erro de inserção, 
	 * pois o JPA perde o controlhe das chaves primarias.
	 * Porque esta definida como @GeneratedValue(strategy = GenerationType.AUTO)
	 * 
	 * Para poder usar o arquivo data.sql e não dar mais erros,
	 * temos que alterar a linha para @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * schema.sql tb pode ser colocado.
	 * 
	 * Pesquisar depois sobre esses arquivos!!!
	 */
	
//	@Bean
//	CommandLineRunner runner() {
//		
//		return args -> {
//			
//			Employee emp1 = new Employee("John", "Warton", "warton@gmail.com");
//			Employee emp2 = new Employee("Mike", "Lanister", "lanister@gmail.com");
//			Employee emp3 = new Employee("Steve", "Reeves", "Reeves@gmail.com");
//
//			Employee emp4 = new Employee("Ronald", "Connor", "connor@gmail.com");
//			Employee emp5 = new Employee("Jim", "Salvator", "Sal@gmail.com");
//			Employee emp6 = new Employee("Peter", "Henley", "henley@gmail.com");
//
//			Employee emp7 = new Employee("Richard", "Carson", "carson@gmail.com");
//			Employee emp8 = new Employee("Honor", "Miles", "miles@gmail.com");
//			Employee emp9 = new Employee("Tony", "Roggers", "roggers@gmail.com");
//
//			
//			Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for"
//					+ "the final deployment of the software into production");
//			Project pro2 = new Project("New Employee Budget",  "COMPLETED", "Decide on a new employee bonus budget"
//					+ "for the year and figureout who will be promoted");
//			Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "The office building in Monroe has "
//					+ "been damaged due to hurricane in the region. This needs to be reconstructed");
//			Project pro4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack, the office"
//					+ "security needs to be improved and proper security team needs to be hired for "
//					+ "implementation");
//			
//			
//			
//			// need to set both sides of the relationship manually
//
//			pro1.addEmployee(emp1);
//			pro1.addEmployee(emp2);
//			pro2.addEmployee(emp3);
//			pro3.addEmployee(emp1);
//			pro4.addEmployee(emp1);
//			pro4.addEmployee(emp3);
//
//			
//			// need to set both sides of the relationship manually
//
//			emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
//			emp2.setProjects(Arrays.asList(pro1));
//			emp3.setProjects(Arrays.asList(pro2, pro4));
//			
//			// save employees in database
//
//			empRepo.save(emp1);
//			empRepo.save(emp2); 
//			empRepo.save(emp3); 
//			empRepo.save(emp4);
//			empRepo.save(emp5); 
//			empRepo.save(emp6); 
//			empRepo.save(emp7); 
//			empRepo.save(emp8); 
//			empRepo.save(emp9);
//
//			
//			// save projects in database
//
//			projRepo.save(pro1);
//			projRepo.save(pro2); 
//			projRepo.save(pro3); 
//			projRepo.save(pro4);
//			
//			
//		};
//		
//	}	
	

}
