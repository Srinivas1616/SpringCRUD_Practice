package com.srinivas.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.srinivas.demo.entities.Employee;

public interface EmpServiceInterface {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	
	public Employee getEmpById(Long empId);

	public void deleteEmpById(Long empId);

}
