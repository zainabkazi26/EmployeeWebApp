package com.thirdproject.employeewebappRC.service;

import java.util.List;

import com.thirdproject.employeewebappRC.entity.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> listAllEmployees();

	Employee getEmployeeById(int eid);

	List<Employee> findByFirstname(String firstname);

	Employee updateEmployeeById(int eid, Employee employeeFE);

	List<Employee> findAllEmployees(String sortBy, String sortDir);

	void deleteEmployeeById(int eid);

}
