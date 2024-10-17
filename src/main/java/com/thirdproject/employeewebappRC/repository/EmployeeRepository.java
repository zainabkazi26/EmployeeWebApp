package com.thirdproject.employeewebappRC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thirdproject.employeewebappRC.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByFirstnameContainsAllIgnoreCase(String firstname);


}
