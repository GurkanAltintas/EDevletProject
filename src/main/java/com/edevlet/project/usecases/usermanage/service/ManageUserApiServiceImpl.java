package com.edevlet.project.usecases.usermanage.service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edevlet.project.usecases.common.entity.user.User;
import com.edevlet.project.usecases.common.utils.RequestConverter;
import com.edevlet.project.usecases.common.utils.RequestValidator;
import com.edevlet.project.usecases.usermanage.entity.GetAllAnnouncementsResponse;
import com.edevlet.project.usecases.usermanage.entity.LoginData;
import com.edevlet.project.usecases.usermanage.entity.LoginRequest;
import com.edevlet.project.usecases.usermanage.entity.LoginResponse;
import com.edevlet.project.usecases.usermanage.entity.SaveAnnouncementRequest;
import com.edevlet.project.usecases.usermanage.entity.SaveAnnouncementResponse;
import com.edevlet.project.usecases.usermanage.entity.SaveUserRequest;
import com.edevlet.project.usecases.usermanage.entity.SaveUserResponse;

@Service
public class ManageUserApiServiceImpl implements ManageUserApiService {

	private static final Integer USERNAME_LOGIN = 1;
	private static final Integer IDENTITY_NUMBER_LOGIN = 2;

	private Map<Integer, Function<LoginRequest, LoginResponse>> processMap;

	@Autowired
	private ManageUserService manageUserService;

	@Override
	public GetAllAnnouncementsResponse getAllAnnouncements() {
		GetAllAnnouncementsResponse response = new GetAllAnnouncementsResponse();
		response.setData(manageUserService.getAllAnnouncements());
		return response;
	}

	@PostConstruct
	private void init() {
		processMap = new HashMap<>();

		processMap.put(IDENTITY_NUMBER_LOGIN, this::loginByIdentityNumber);
		processMap.put(USERNAME_LOGIN, this::loginByUserName);
	}

	@Override
	public LoginResponse login(LoginRequest request) {
		RequestValidator.validateLoginRequest(request);
		return processMap.getOrDefault(request.getLoginType(), this::loginByIdentityNumber).apply(request);
	}

	private LoginResponse loginByIdentityNumber(LoginRequest request) {
		LoginData data = new LoginData();
		data.setCanLogin(true);
		data.setCode("success");
		data.setDetail("Successfull");

		User user = manageUserService.getUserByIdentityNumber(request.getLoginValue());
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

	private LoginResponse loginByUserName(LoginRequest request) {
		LoginData data = new LoginData();
		data.setCanLogin(true);
		data.setCode("success");
		data.setDetail("Successfull");

		User user = manageUserService.getUserByUsername(request.getLoginValue());
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
	public SaveAnnouncementResponse saveAnnouncement(SaveAnnouncementRequest request) {
		manageUserService.saveAnnouncement(RequestConverter.convertToAnnouncement(request));
		return new SaveAnnouncementResponse();
	}

	@Override
	public SaveUserResponse saveUser(SaveUserRequest request) {
		RequestValidator.validateSaveUserRequest(request);

		boolean isUserExist = manageUserService.getUserByIdentityNumber(request.getIdentityNumber()) != null;
		if (isUserExist) {
			throw new RuntimeException("user already exists");
		}

		manageUserService.saveUser(RequestConverter.convertToUser(request));
		return new SaveUserResponse();
	}

}
