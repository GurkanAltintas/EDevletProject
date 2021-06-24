package com.edevlet.project.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.edevlet.project.entity.rest.manageuser.LoginRequest;
import com.edevlet.project.entity.rest.manageuser.LoginResponse;
import com.edevlet.project.entity.rest.manageuser.SaveAnnouncementRequest;
import com.edevlet.project.entity.rest.manageuser.SaveAnnouncementResponse;
import com.edevlet.project.entity.rest.manageuser.SaveUserRequest;
import com.edevlet.project.entity.rest.manageuser.SaveUserResponse;
import com.edevlet.project.services.ManageUserRestApiService;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class ManageUserRestController {

	@Autowired
	private ManageUserRestApiService manageUserApiService;

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
