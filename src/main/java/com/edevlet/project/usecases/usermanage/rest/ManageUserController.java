package com.edevlet.project.usecases.usermanage.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edevlet.project.usecases.usermanage.entity.FeedBackRequest;
import com.edevlet.project.usecases.usermanage.entity.FeedBackResponse;
import com.edevlet.project.usecases.usermanage.entity.FetchDiseasesRequest;
import com.edevlet.project.usecases.usermanage.entity.FetchDiseasesResponse;
import com.edevlet.project.usecases.usermanage.entity.FetchRecipesRequest;
import com.edevlet.project.usecases.usermanage.entity.FetchRecipesResponse;
import com.edevlet.project.usecases.usermanage.entity.FetchReportsRequest;
import com.edevlet.project.usecases.usermanage.entity.FetchReportsResponse;
import com.edevlet.project.usecases.usermanage.entity.FetchVizitsRequest;
import com.edevlet.project.usecases.usermanage.entity.FetchVizitsResponse;
import com.edevlet.project.usecases.usermanage.entity.GetAllAnnouncementsResponse;
import com.edevlet.project.usecases.usermanage.entity.GetAllFeedBacksResponse;
import com.edevlet.project.usecases.usermanage.entity.LoginRequest;
import com.edevlet.project.usecases.usermanage.entity.LoginResponse;
import com.edevlet.project.usecases.usermanage.entity.SaveAnnouncementRequest;
import com.edevlet.project.usecases.usermanage.entity.SaveAnnouncementResponse;
import com.edevlet.project.usecases.usermanage.entity.SaveUserRequest;
import com.edevlet.project.usecases.usermanage.entity.SaveUserResponse;
import com.edevlet.project.usecases.usermanage.service.ManageUserApiService;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class ManageUserController {

	@Autowired
	private ManageUserApiService manageUserApiService;

	@PostMapping("/feedBack")
	public FeedBackResponse feedBack(@RequestBody FeedBackRequest request) {
		return manageUserApiService.feedBack(request);
	}

	@PostMapping("/fetchDiseases")
	public FetchDiseasesResponse fetchDiseases(@RequestBody FetchDiseasesRequest request) {
		return manageUserApiService.fetchDiseases(request);
	}

	@PostMapping("/fetchRecipes")
	public FetchRecipesResponse fetchRecipes(@RequestBody FetchRecipesRequest request) {
		return manageUserApiService.fetchRecipes(request);
	}

	@PostMapping("/fetchReports")
	public FetchReportsResponse fetchReports(@RequestBody FetchReportsRequest request) {
		return manageUserApiService.fetchReports(request);
	}

	@PostMapping("/fetchVizits")
	public FetchVizitsResponse fetchVizits(@RequestBody FetchVizitsRequest request) {
		return manageUserApiService.fetchVizits(request);
	}

	@GetMapping("/admin/getAllAnnouncements")
	public GetAllAnnouncementsResponse getAllAnnouncements() {
		return manageUserApiService.getAllAnnouncements();
	}

	@GetMapping("/getAllFeedBacks")
	public GetAllFeedBacksResponse getAllFeedBacks() {

		return manageUserApiService.getAllFeedBacks();
	}

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {
		return manageUserApiService.login(request);
	}

	@PostMapping("/admin/saveAnnouncement")
	public SaveAnnouncementResponse saveAnnouncement(@RequestBody SaveAnnouncementRequest request) {

		return manageUserApiService.saveAnnouncement(request);
	}

	@PostMapping("/saveUser")
	public SaveUserResponse saveUser(@RequestBody SaveUserRequest request) {
		return manageUserApiService.saveUser(request);
	}
}
