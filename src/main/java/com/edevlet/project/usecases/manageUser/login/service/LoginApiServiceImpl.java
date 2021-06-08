package com.edevlet.project.usecases.manageUser.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edevlet.project.usecases.common.entity.user.User;
import com.edevlet.project.usecases.manageUser.login.entity.LoginData;
import com.edevlet.project.usecases.manageUser.login.entity.LoginRequest;
import com.edevlet.project.usecases.manageUser.login.entity.LoginResponse;

@Service
public class LoginApiServiceImpl implements LoginApiService {

	@Autowired
	private LoginService loginService;

	@Override
	public LoginResponse login(LoginRequest request) {

		LoginData data = new LoginData();
		data.setCanLogin(true);
		data.setCode("success");
		data.setDetail("Successfull");

		User user = loginService.getUserByUsername(request.getUsername());
		if (user == null) {
			data.setCanLogin(false);
			data.setCode("user.not.found");
			data.setDetail("User cannot found");
		}

		else if (!user.getPassword().equals(request.getPassword())) {
			data.setCanLogin(false);
			data.setCode("password.doesnt.match");
			data.setDetail("Wrong Password");
			data.setCanLogin(false);
		}

		LoginResponse response = new LoginResponse();
		response.setData(data);

		return response;
	}
}
