package com.edevlet.project.usecases.common.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String surname;
	private String identityNumber;
	private String username;
	private String password;
	private String mailAdress;
	private String phoneNumber;
}
