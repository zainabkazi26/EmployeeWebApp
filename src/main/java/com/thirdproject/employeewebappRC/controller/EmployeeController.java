package com.thirdproject.employeewebappRC.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thirdproject.employeewebappRC.entity.Employee;
import com.thirdproject.employeewebappRC.service.EmployeeService;

@RestController
@RequestMapping("/apiemp")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmployeeByRequestParam")
	public Employee addTeacher(@RequestParam("p1") String firstname, @RequestParam("p2") String lastname,
			@RequestParam("p3") String email) {

		Employee employee = new Employee();
		employee.setFirstname(firstname);
		employee.setLastname(lastname);
		employee.setEmail(email);

		return employeeService.createEmployee(employee);
	}
	
	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

		return ResponseEntity.status(HttpStatus.CREATED).body((employeeService.createEmployee(employee)));
	}
		
	
	@GetMapping("/listAllEmployees")
	public ResponseEntity<List<Employee>> listAllEmployees(){
		return new ResponseEntity<List<Employee>>(employeeService.listAllEmployees(),HttpStatus.FOUND);
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable ("id")int eid){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(eid),HttpStatus.FOUND);
	}
	
	@GetMapping("/searchEmployeeByFirstname/{firstname}")
	public ResponseEntity<List<Employee>> searchEmployeeByFirstname(@PathVariable("firstname") String firstname){
		return new ResponseEntity<List<Employee>>(employeeService.findByFirstname(firstname),HttpStatus.FOUND);
		
	}
	
	@PutMapping("/updateEmployeeById")
	public ResponseEntity<Employee> updateEmployeeById(@RequestParam("id")int eid, @RequestBody Employee employeeFE){
		return new ResponseEntity<Employee>(employeeService.updateEmployeeById(eid,employeeFE),HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteEmployeeById/{eid}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable ("eid")int eid){
		employeeService.deleteEmployeeById(eid);
		return new ResponseEntity<>("User ID " + eid + " has been successfully deleted!",HttpStatus.OK);
	}
	
	
	@GetMapping("/sort")
	public ResponseEntity<List<Employee>> getAllEmployee(
			@RequestParam(value = "sortBy", defaultValue = "firstname", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {
		return new ResponseEntity<List<Employee>>(employeeService.findAllEmployees(sortBy, sortDir), HttpStatus.OK);
	}
}
