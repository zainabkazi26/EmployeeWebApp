package com.thirdproject.employeewebappRC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thirdproject.employeewebappRC.entity.Users;
import com.thirdproject.employeewebappRC.service.UsersService;

@RestController
@RequestMapping("/apiemp")
public class UsersController {
	@Autowired
	UsersService usersService;

	@PostMapping("/users")
	public Users addUser(@RequestBody Users user) {
		return usersService.addUser(user);
	}
}
