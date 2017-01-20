package com.assessment.app;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import com.assessment.app.model.Employee;
import com.assessment.app.model.User;
import com.assessment.app.repository.EmployeeRepository;
import com.assessment.app.repository.ValidationRepository;
/**
 * 
 * @author Rui Hu
 *
 */
@SpringBootApplication
public class CrudEmpApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CrudEmpApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CrudEmpApplication.class, args);
	}
	
	/**
	 * Save Employee to temp database(H2) for testing
	 */
	@Bean
	public CommandLineRunner demo(EmployeeRepository repository, ValidationRepository validationRepository) {
		return (args) -> {
	 
			repository.save(new Employee("Patrick", "Edison", "IT", "Patrick@assessment.com"));
			repository.save(new Employee("Avisheck", "Pam", "IT", "Avisheck@assessment.com"));
			repository.save(new Employee("Kelsey", "Griggs", "IT", "Kelsey@assessment.com"));
			repository.save(new Employee("Penfei ", "Qian", "Financial","Qian@assessment.com"));
			repository.save(new Employee("Ram", "Vishnu", "Business","Ram@assessment.com"));
			repository.save(new Employee("James", "Roy", "Business","James@assessment.com"));
			repository.save(new Employee("Hang", "Yin", "Business","Hang@assessment.com"));
			repository.save(new Employee("James", "Roy", "Business","James@assessment.com"));
			
			validationRepository.save(new User("hurui","123"));
			validationRepository.save(new User("scott","123"));
			
		};
	}
	 

}
