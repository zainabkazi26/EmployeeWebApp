package com.thirdproject.employeewebappRC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thirdproject.employeewebappRC.entity.Users;
@Repository
public interface UsersRepository  extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);

}
