package com.edevlet.project.usecases.usermanage.service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edevlet.project.usecases.common.adapter.EntityToResponseAdapter;
import com.edevlet.project.usecases.common.adapter.EntityToResponseAdapterImpl;
import com.edevlet.project.usecases.common.adapter.RequestToEntityAdapterImpl;
import com.edevlet.project.usecases.common.command.Broker;
import com.edevlet.project.usecases.common.command.CheckFeedBackOperation;
import com.edevlet.project.usecases.common.command.FeedBackOperator;
import com.edevlet.project.usecases.common.command.SaveFeedBackOperation;
import com.edevlet.project.usecases.common.entity.user.Announcement;
import com.edevlet.project.usecases.common.entity.user.Feedback;
import com.edevlet.project.usecases.common.entity.user.User;
import com.edevlet.project.usecases.common.utils.RequestValidator;
import com.edevlet.project.usecases.usermanage.entity.FeedBackRequest;
import com.edevlet.project.usecases.usermanage.entity.FeedBackResponse;
import com.edevlet.project.usecases.usermanage.entity.GetAllAnnouncementsResponse;
import com.edevlet.project.usecases.usermanage.entity.GetAllFeedBacksResponse;
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
	public FeedBackResponse feedBack(FeedBackRequest request) {
		String feedback = request.getFeedback();

		FeedBackOperator feedBackOperator = new FeedBackOperator();
		feedBackOperator.setMessage(feedback);

		CheckFeedBackOperation checkFeedBack = new CheckFeedBackOperation(feedBackOperator);
		SaveFeedBackOperation saveFeedBack = new SaveFeedBackOperation(feedBackOperator);

		Broker broker = new Broker();
		broker.takeOrder(checkFeedBack);
		broker.takeOrder(saveFeedBack);
		broker.placeOrders();

		Feedback entity = new Feedback();
		entity.setFeedBack(feedBackOperator.getMessage());

		manageUserService.saveFeedBack(entity);
		return new FeedBackResponse();
	}

	@Override
	public GetAllAnnouncementsResponse getAllAnnouncements() {
		GetAllAnnouncementsResponse response = new GetAllAnnouncementsResponse();
		response.setData(manageUserService.getAllAnnouncements());
		return response;
	}

	@Override
	public GetAllFeedBacksResponse getAllFeedBacks() {
		EntityToResponseAdapter entityToResponseAdapter = new EntityToResponseAdapterImpl();
		return entityToResponseAdapter.convertEntityToResponse(GetAllFeedBacksResponse.class,
				manageUserService.getAllFeedbacks());
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
		manageUserService
				.saveAnnouncement(new RequestToEntityAdapterImpl().convertRequestToEntity(Announcement.class, request));
		return new SaveAnnouncementResponse();
	}

	@Override
	public SaveUserResponse saveUser(SaveUserRequest request) {
		RequestValidator.validateSaveUserRequest(request);

		boolean isUserExist = manageUserService.getUserByIdentityNumber(request.getIdentityNumber()) != null;
		if (isUserExist) {
			throw new RuntimeException("user already exists");
		}

		manageUserService.saveUser(new RequestToEntityAdapterImpl().convertRequestToEntity(User.class, request));
		// manageUserService.saveUser(RequestConverter.convertToUser(request));
		return new SaveUserResponse();
	}

}
