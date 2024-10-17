package com.thirdproject.employeewebappRC.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.thirdproject.employeewebappRC.entity.Employee;
import com.thirdproject.employeewebappRC.repository.EmployeeRepository;
import com.thirdproject.employeewebappRC.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> listAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int eid) {
		return employeeRepository.findById(eid).get();
	}

	@Override
	public List<Employee> findByFirstname(String firstname) {
		return employeeRepository.findByFirstnameContainsAllIgnoreCase(firstname);
	}

	@Override
	public Employee updateEmployeeById(int eid, Employee employeeFE) {
		Employee employeeDB=employeeRepository.findById(eid).get();
		employeeDB.setFirstname(employeeFE.getFirstname());
		employeeDB.setLastname(employeeFE.getLastname());
		employeeDB.setEmail(employeeFE.getEmail());
			return employeeRepository.save(employeeDB);
	}

	public void deleteEmployeeById(int eid) {
		
		 employeeRepository.deleteById(eid);
	}

	
	@Override
	public List<Employee> findAllEmployees(String sortBy, String sortDir) {
		Sort sort = null;
		if (sortDir.trim().toLowerCase().equals("asc")) {
			sort = Sort.by(sortBy).ascending();
		} else {
			sort = Sort.by(sortBy).descending();
		}
		Pageable pageable = PageRequest.of(0, 10, sort);
		Page<Employee> allPages = this.employeeRepository.findAll(pageable);
		List<Employee> allEmployees = allPages.getContent();
		return allEmployees;
	}

}
