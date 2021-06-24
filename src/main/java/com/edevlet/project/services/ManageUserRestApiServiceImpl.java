package com.edevlet.project.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edevlet.project.entity.db.Announcement;
import com.edevlet.project.entity.db.Disease;
import com.edevlet.project.entity.db.Feedback;
import com.edevlet.project.entity.db.Recipe;
import com.edevlet.project.entity.db.Report;
import com.edevlet.project.entity.db.User;
import com.edevlet.project.entity.db.Vizit;
import com.edevlet.project.entity.rest.manageuser.DiseaseDTO;
import com.edevlet.project.entity.rest.manageuser.FeedBackRequest;
import com.edevlet.project.entity.rest.manageuser.FeedBackResponse;
import com.edevlet.project.entity.rest.manageuser.FetchDiseasesRequest;
import com.edevlet.project.entity.rest.manageuser.FetchDiseasesResponse;
import com.edevlet.project.entity.rest.manageuser.FetchRecipesRequest;
import com.edevlet.project.entity.rest.manageuser.FetchRecipesResponse;
import com.edevlet.project.entity.rest.manageuser.FetchReportsRequest;
import com.edevlet.project.entity.rest.manageuser.FetchReportsResponse;
import com.edevlet.project.entity.rest.manageuser.FetchVizitsRequest;
import com.edevlet.project.entity.rest.manageuser.FetchVizitsResponse;
import com.edevlet.project.entity.rest.manageuser.GetAllAnnouncementsResponse;
import com.edevlet.project.entity.rest.manageuser.GetAllFeedBacksResponse;
import com.edevlet.project.entity.rest.manageuser.LoginData;
import com.edevlet.project.entity.rest.manageuser.LoginRequest;
import com.edevlet.project.entity.rest.manageuser.LoginResponse;
import com.edevlet.project.entity.rest.manageuser.RecipeDTO;
import com.edevlet.project.entity.rest.manageuser.ReportDTO;
import com.edevlet.project.entity.rest.manageuser.SaveAnnouncementRequest;
import com.edevlet.project.entity.rest.manageuser.SaveAnnouncementResponse;
import com.edevlet.project.entity.rest.manageuser.SaveUserRequest;
import com.edevlet.project.entity.rest.manageuser.SaveUserResponse;
import com.edevlet.project.entity.rest.manageuser.VizitDTO;
import com.edevlet.project.patterns.adapter.EntityToResponseAdapter;
import com.edevlet.project.patterns.adapter.EntityToResponseAdapterImpl;
import com.edevlet.project.patterns.adapter.RequestToEntityAdapterImpl;
import com.edevlet.project.patterns.command.Broker;
import com.edevlet.project.patterns.command.CheckFeedBackOperation;
import com.edevlet.project.patterns.command.FeedBackOperator;
import com.edevlet.project.patterns.command.SaveFeedBackOperation;
import com.edevlet.project.patterns.iterator.Iterator;
import com.edevlet.project.patterns.iterator.NameRepository;
import com.edevlet.project.patterns.observer.AnnouncmentObservable;
import com.edevlet.project.patterns.observer.AnnouncmentObserver;
import com.edevlet.project.patterns.utils.RequestValidator;

@Service
public class ManageUserRestApiServiceImpl implements ManageUserRestApiService {

	private static final Integer USERNAME_LOGIN = 1;
	private static final Integer IDENTITY_NUMBER_LOGIN = 2;

	private Map<Integer, Function<LoginRequest, LoginResponse>> processMap;

	@Autowired
	private ManageUserService manageUserService;

	@Autowired
	private MailService mailService;

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
	public FetchDiseasesResponse fetchDiseases(FetchDiseasesRequest request) {

		boolean isTcKimlikNo = NumberUtils.isCreatable(request.getUserInfo());

		// TODO: @oguzt, kod tekrarina çözüm bulalım
		List<Disease> diseaseList = manageUserService.getAllDisease();
		List<Disease> userDiseaseList = diseaseList.stream()
				.filter(f -> isTcKimlikNo ? f.getUser().getIdentityNumber().equals(request.getUserInfo())
						: f.getUser().getUsername().equals(request.getUserInfo()))
				.collect(Collectors.toList());

		FetchDiseasesResponse response = new FetchDiseasesResponse();
		response.setData(userDiseaseList.stream().map(m -> {

			DiseaseDTO dto = new DiseaseDTO();
			dto.setClinic(m.getClinic().getClinicName());
			dto.setDiagnosis(m.getDiagnosis());
			dto.setDiagnosisDate(m.getDiagnosisDate());
			dto.setDoctor(m.getDoctor().getDoctorName() + " " + m.getDoctor().getDoctorSurname());

			return dto;
		}).collect(Collectors.toList()));
		return response;
	}

	// TODO: İterator.

	@Override
	public FetchRecipesResponse fetchRecipes(FetchRecipesRequest request) {

		boolean isTcKimlikNo = NumberUtils.isCreatable(request.getUserInfo());

		List<Recipe> allRecipes = manageUserService.getAllRecipes();
		List<Recipe> userRecipes = allRecipes.stream()
				.filter(f -> isTcKimlikNo ? f.getUser().getIdentityNumber().equals(request.getUserInfo())
						: f.getUser().getUsername().equals(request.getUserInfo()))
				.collect(Collectors.toList());

		FetchRecipesResponse response = new FetchRecipesResponse();

		List<RecipeDTO> dataList = new ArrayList<>();
		NameRepository nameRepository = new NameRepository(userRecipes);
		Iterator iterator = nameRepository.getIterator();

		while (iterator.hasNext()) {
			Recipe rec = (Recipe) iterator.next();
			RecipeDTO dto = new RecipeDTO();

			dto.setDoctor(rec.getDoctor().getDoctorName() + " " + rec.getDoctor().getDoctorSurname());
			dto.setRecepiDate(rec.getRecepiDate());
			dto.setRecepiNumber(rec.getRecepiNumber());
			dto.setRecepiType(rec.getRecepiType());
			dataList.add(dto);

		}

		response.setData(dataList);

		return response;
	}

	@Override
	public FetchReportsResponse fetchReports(FetchReportsRequest request) {

		boolean isTcKimlikNo = NumberUtils.isCreatable(request.getUserInfo());
		List<Report> reportList = manageUserService.getAllReports();
		List<Report> userReportList = reportList.stream()
				.filter(f -> isTcKimlikNo ? f.getUser().getIdentityNumber().equals(request.getUserInfo())
						: f.getUser().getUsername().equals(request.getUserInfo()))
				.collect(Collectors.toList());

		FetchReportsResponse response = new FetchReportsResponse();
		response.setData(userReportList.stream().map(m -> {

			ReportDTO dto = new ReportDTO();
			dto.setDiagnosis(m.getDiagnosis());
			dto.setEndDate(m.getEndDate());
			dto.setReportDate(m.getReportDate());
			dto.setReportNumber(m.getReportNumber());
			dto.setReportTrackingNumber(m.getReportTrackingNumber());
			dto.setReportType(m.getReportType());
			dto.setStartDate(m.getStartDate());

			return dto;
		}).collect(Collectors.toList()));

		return response;
	}

	@Override
	public FetchVizitsResponse fetchVizits(FetchVizitsRequest request) {

		boolean isTcKimlikNo = NumberUtils.isCreatable(request.getUserInfo());

		List<Vizit> allVizits = manageUserService.getAllVizits();

		List<Vizit> userVizits = allVizits.stream()
				.filter(f -> isTcKimlikNo ? f.getUser().getIdentityNumber().equals(request.getUserInfo())
						: f.getUser().getUsername().equals(request.getUserInfo()))
				.collect(Collectors.toList());

		FetchVizitsResponse response = new FetchVizitsResponse();
		response.setData(userVizits.stream().map(m -> {
			VizitDTO dto = new VizitDTO();
			dto.setClinicName(m.getClinic().getClinicName());
			dto.setDoctorName(m.getDoctor().getDoctorName() + " " + m.getDoctor().getDoctorSurname());
			dto.setHospitalName(m.getHospital().getHospitalName());
			dto.setTrackingNumber(m.getTrackingNumber());
			dto.setVizitDate(m.getVizitDate());

			return dto;
		}).collect(Collectors.toList()));

		return response;
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

		AnnouncmentObservable observable = new AnnouncmentObservable(request.getAnnouncement());
		observable.add(new AnnouncmentObserver(manageUserService, mailService));
		observable.notifyObservers();

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
