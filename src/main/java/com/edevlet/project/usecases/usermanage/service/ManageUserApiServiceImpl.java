package com.edevlet.project.usecases.usermanage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edevlet.project.usecases.common.entity.user.User;
import com.edevlet.project.usecases.common.utils.RequestConverter;
import com.edevlet.project.usecases.common.utils.RequestValidator;
import com.edevlet.project.usecases.usermanage.entity.LoginData;
import com.edevlet.project.usecases.usermanage.entity.LoginRequest;
import com.edevlet.project.usecases.usermanage.entity.LoginResponse;
import com.edevlet.project.usecases.usermanage.entity.SaveUserRequest;
import com.edevlet.project.usecases.usermanage.entity.SaveUserResponse;

@Service
public class ManageUserApiServiceImpl implements ManageUserApiService {

	@Autowired
	private ManageUserService manageUserService;

	@Override
	public LoginResponse login(LoginRequest request) {

		LoginData data = new LoginData();
		data.setCanLogin(true);
		data.setCode("success");
		data.setDetail("Successfull");

		User user = manageUserService.getUserByUsername(request.getUsername());
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

	@Override
	public SaveUserResponse saveUser(SaveUserRequest request) {
		RequestValidator.validateSaveUserRequest(request);
		manageUserService.saveUser(RequestConverter.convertToUser(request));
		return new SaveUserResponse();
	}

}
