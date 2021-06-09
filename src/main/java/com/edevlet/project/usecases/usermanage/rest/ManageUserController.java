package com.edevlet.project.usecases.usermanage.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edevlet.project.usecases.usermanage.entity.LoginRequest;
import com.edevlet.project.usecases.usermanage.entity.LoginResponse;
import com.edevlet.project.usecases.usermanage.entity.SaveUserRequest;
import com.edevlet.project.usecases.usermanage.entity.SaveUserResponse;
import com.edevlet.project.usecases.usermanage.service.ManageUserApiService;

@RestController
@RequestMapping(value = "/api/user")
public class ManageUserController {

	@Autowired
	private ManageUserApiService manageUserApiService;

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {
		return manageUserApiService.login(request);
	}

	@PostMapping("/saveUser")
	public SaveUserResponse saveUser(@RequestBody SaveUserRequest request) {
		return manageUserApiService.saveUser(request);
	}
}
