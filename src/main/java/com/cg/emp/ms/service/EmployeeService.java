package com.cg.emp.ms.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.emp.ms.exceptions.EmployeeNotFoundException;
import com.cg.emp.ms.model.Employee;
import com.cg.emp.ms.repository.EmployeeRepository;

@Service
public class EmployeeService {

	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	EmployeeRepository repository;

	public List<Employee> getAllEmployees() {
		List<Employee> employess = repository.findAll();
		return employess;
	}

	public Employee getEmployeeById(Long empId) {
		Employee employee = null;
		Optional<Employee> optionalEmployee = repository.findById(empId);
		if (optionalEmployee.isPresent())
			employee = optionalEmployee.get();
		else
			throw new EmployeeNotFoundException("Employee not Found with the given Id.");
		return employee;
	}

	public List<Employee> getEmployeeByName(String LastName) {
//		List<Employee> empList = repository.findByLastName(LastName);
		List<Employee> empList = repository.findAll();
		Iterator<Employee> iterator = empList.iterator();
		if (iterator.next().getLastName().equals(LastName)) {
			return empList;
		} else {
			throw new EmployeeNotFoundException("Employee not Found with the given name.");
		}
	}

	public Employee addEmployee(Employee employee) {

		Employee emp = repository.save(employee);

		return emp;
	}

	public Employee updateEmployee(Employee employee) {

		Employee emp = repository.save(employee);

		return emp;
	}

	public Employee deleteEmployee(Long empId) {
		repository.deleteById(empId);
		return getEmployeeById(empId);
	}

}
