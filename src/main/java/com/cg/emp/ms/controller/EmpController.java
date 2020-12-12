package com.cg.emp.ms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.emp.ms.model.Employee;
import com.cg.emp.ms.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
public class EmpController {

	public EmpController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	EmployeeService empService;

	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmp() {
		System.out.println("getAllEmp"); // remove these statements in production 
		return empService.getAllEmployees();
	}

	@GetMapping("/getEmpById/{empId}")
	public Employee getEmpById(@PathVariable Long empId) {
		System.out.println("getEmpById");
		return empService.getEmployeeById(empId);
	}

	@GetMapping("/getEmpByName/{lastName}")
	public List<Employee> getEmpByName(@PathVariable String lastName) {
		System.out.println("getEmpByName");
		return empService.getEmployeeByName(lastName);
	}

	@PostMapping(value = "/addEmp", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee addEmp(@Valid @RequestBody Employee employee) {
		System.out.println("addEmp");
		Employee emp = empService.addEmployee(employee);
		return emp;
	}

	@PutMapping(value = "/updateEmp", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee updateEmp(@Valid @RequestBody Employee employee) {
		System.out.println("updateEmp");
		Employee emp = empService.updateEmployee(employee);
		return emp;
	}

	@DeleteMapping("/deleteEmp/{empId}")
	public Employee deleteEmp(@PathVariable Long empId) {
		System.out.println("deleteEmp");
		return empService.deleteEmployee(empId);

	}

}
