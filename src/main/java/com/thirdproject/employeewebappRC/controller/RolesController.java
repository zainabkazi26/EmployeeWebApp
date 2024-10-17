package com.thirdproject.employeewebappRC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thirdproject.employeewebappRC.entity.Roles;
import com.thirdproject.employeewebappRC.service.RolesService;

@RestController
@RequestMapping("/apiemp")
public class RolesController {
	@Autowired
	RolesService rolesService;

	@PostMapping("/roles")
	public Roles addRole(@RequestBody Roles role) {
		return rolesService.addRole(role);
	}
}
