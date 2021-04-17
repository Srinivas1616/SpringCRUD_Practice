package com.srinivas.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.srinivas.demo.entities.Employee;
import com.srinivas.demo.repositroy.EmpRepo;

@Service
public class EmpService implements EmpServiceInterface{
	
	@Autowired
	private EmpRepo crudRepo; 

	@Override
	public Employee addEmployee(Employee employee) {
		
		return crudRepo.save(employee);
	
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return crudRepo.findAll();
	
	}

	@Override
	public Employee getEmpById(Long empId) {
		return crudRepo.findById(empId).get();
	}

	@Override
	public void deleteEmpById(Long empId) {
		crudRepo.deleteById(empId);
		
	}

}
