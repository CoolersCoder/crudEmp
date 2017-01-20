package com.assessment.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.assessment.app.model.Employee;
import com.assessment.app.repository.EmployeeRepository;
import com.assessment.app.repository.ValidationRepository;

@Controller
public class EmployeeController {
	@Autowired
    private EmployeeRepository repository; 
	@Autowired
	private ValidationRepository validationRepository;
	
	
	@RequestMapping(value="verify",method = RequestMethod.POST)
	public String verifyUser(Model model,@RequestParam("username") String username,
			@RequestParam("password") String password) {		
		if(validationRepository.findByUsernameAndPassword(username, password)!=null){
			return "redirect:/employee_data";
		}
		model.addAttribute("Error","Please check your username and password");
    	return "/index";
    }
	
	@RequestMapping("/")
	public String indexPage(Model model) {	
    	return "index";
    }
	
	@RequestMapping("/employee_data")
	public String login(Model model) {	
		List<Employee> employees = (List<Employee>) repository.findAll();		
		model.addAttribute("employees", employees);	
		return "login";
    }

    @RequestMapping(value = "add")
    public String addEmployee(Model model){
    	model.addAttribute("employee", new Employee());
        return "addEmployee";
    }	
	
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Employee employee){
        repository.save(employee);
    	return "redirect:/employee_data";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Long employeeId, Model model) {
    	repository.delete(employeeId);
        return "redirect:/employee_data";
    }    
    
    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String modifyEmployee(@PathVariable("id") Long employeeId, Model model) {
    	Employee employeeOne = repository.findOne(employeeId);
    	model.addAttribute("employeeOne", employeeOne);	
        return "addEmployee";
    } 
}
