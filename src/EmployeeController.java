package com.rudraksh.EC2RDScruddemo.Cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rudraksh.EC2RDScruddemo.Model.Employee;
import com.rudraksh.EC2RDScruddemo.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	//display employee list 
	@GetMapping("/")
	public String showEmployee(Model model) {
		
		List<Employee> employeeList = employeeRepository.findAll();
		
		model.addAttribute("employee",employeeList);
		
		return "index";
	}	
	
	//display form for filling the employee information
	@GetMapping("/employeeForm")
	public String showEmployeeForm(Model model) {
		
		Employee theEmployee = new Employee();
		model.addAttribute("employee",theEmployee);
		return "employee-form";
	}
	
	//method for saving the employee information
	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute Employee employee,Model model) {
		//System.out.println(employee);
		model.addAttribute("employee",employee);
		employeeRepository.save(employee);
		return "redirect:/";
	}
}
