package com.cg.emp.ms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.emp.ms.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//	List<Employee> findByLastName(String lastName);

//	@Query("SELECT e.name FROM Employee e WHERE e.eid=?1")
	public Employee findById(long empId);

}
