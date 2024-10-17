package com.thirdproject.employeewebappRC.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thirdproject.employeewebappRC.entity.Roles;
import com.thirdproject.employeewebappRC.repository.RolesRepository;
import com.thirdproject.employeewebappRC.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	RolesRepository rolesRepository;

	@Override
	public Roles addRole(Roles role) {
		return rolesRepository.save(role);
	}

}
