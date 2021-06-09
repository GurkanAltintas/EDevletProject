package com.edevlet.project.usecases.usermanage.entity;

public class SaveUserRequest {
	private String name;
	private String surname;
	private String identityNumber;
	private String username;
	private String password;
	private String mailAdress;
	private String phoneNumber;

	public String getIdentityNumber() {
		return identityNumber;
	}

	public String getMailAdress() {
		return mailAdress;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getSurname() {
		return surname;
	}

	public String getUsername() {
		return username;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
