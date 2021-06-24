package com.edevlet.project.entity.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Name")
	private String name;
	@Column(name = "Surname")
	private String surname;
	@Column(name = "IdentityNumber")
	private String identityNumber;
	@Column(name = "Username")
	private String username;
	@Column(name = "Password")
	private String password;
	@Column(name = "MailAdress")
	private String mailAdress;
	@Column(name = "PhoneNumber")
	private String phoneNumber;
}
