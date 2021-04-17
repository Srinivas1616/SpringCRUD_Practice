package com.srinivas.demo.controller;

import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srinivas.demo.entities.Employee;
import com.srinivas.demo.repositroy.EmpRepo;
import com.srinivas.demo.service.EmpService;
import com.srinivas.demo.service.EmpServiceInterface;

@RestController
@RequestMapping("/code")
public class EmpController {
	
	@Autowired
	EmpRepo empRepo;
	
	@Autowired
	private EmpServiceInterface empServiceInterface;
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		System.out.println("Getting all employees");
		return empRepo.findAll();
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee employeeSaved = empServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
		
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> listOfAllEmps = empServiceInterface.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listOfAllEmps, HttpStatus.OK);
	}
	
	@GetMapping("/emp/{empId}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("empId") Long empId){
		Employee empRetrieved = empServiceInterface.getEmpById(empId);
		return new ResponseEntity<Employee>(empRetrieved, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("empId") Long empId){
		empServiceInterface.deleteEmpById(empId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee employeeSaved = empServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
		
	}
	
}
