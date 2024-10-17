package com.thirdproject.employeewebappRC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thirdproject.employeewebappRC.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer>{

}
