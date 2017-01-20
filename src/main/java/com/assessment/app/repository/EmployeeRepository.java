package com.assessment.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assessment.app.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByLastName(String lastname);  
}
