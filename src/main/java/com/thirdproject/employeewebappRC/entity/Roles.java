package com.thirdproject.employeewebappRC.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roles {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int role_id;
	private String name;
}
