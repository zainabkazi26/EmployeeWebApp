package com.thirdproject.employeewebappRC.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thirdproject.employeewebappRC.entity.Roles;
import com.thirdproject.employeewebappRC.entity.Users;
import com.thirdproject.employeewebappRC.repository.RolesRepository;
import com.thirdproject.employeewebappRC.repository.UsersRepository;
import com.thirdproject.employeewebappRC.service.UsersService;
@Service
public class UserServiceImpl implements UsersService{

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	RolesRepository rolesRepository;

	@Override
	public Users addUser(Users user) {

		List<Roles> roles = user.getRoles();

		Set<Roles> rolesFromRepo = new HashSet<Roles>();
		for (Roles role : roles) {
			Roles roleUser = rolesRepository.findById(role.getRole_id()).get();
			rolesFromRepo.add(roleUser);
		}
		user.getRoles().clear();
		for (Roles role : rolesFromRepo) {
			user.addRole(role);
		}

		return usersRepository.save(user);
	}

}
