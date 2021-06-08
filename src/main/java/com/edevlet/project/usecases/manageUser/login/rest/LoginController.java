package com.edevlet.project.usecases.manageUser.login.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edevlet.project.usecases.manageUser.login.entity.LoginRequest;
import com.edevlet.project.usecases.manageUser.login.entity.LoginResponse;
import com.edevlet.project.usecases.manageUser.login.service.LoginApiService;

@RestController
@RequestMapping(value = "/api")
public class LoginController {

	@Autowired
	private LoginApiService loginApiService;

	/*
	 * @PostConstruct private void init() { User user1 = new User();
	 * user1.setIdentityNumber("54622024050");
	 * user1.setMailAdress("oguztklu@gmail.com"); user1.setName("Oğuzhan");
	 * user1.setPassword("oguzhan33"); user1.setPhoneNumber("5452326906");
	 * user1.setSurname("Toklu"); user1.setUsername("oguzt");
	 *
	 * User user2 = new User(); user2.setIdentityNumber("12345678912");
	 * user2.setMailAdress("qurkan.a00@gmail.com"); user2.setName("Gürkan");
	 * user2.setPassword("Ankara103"); user2.setPhoneNumber("5000000000");
	 * user2.setSurname("Altintas"); user2.setUsername("qurkan");
	 *
	 * List.of(user1, user2).forEach(loginDao::save);
	 *
	 * }
	 */

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {
		return loginApiService.login(request);
	}
}
