package com.edevlet.project.usecases.usermanage.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edevlet.project.usecases.usermanage.dao.ClinicDao;
import com.edevlet.project.usecases.usermanage.dao.HospitalDao;
import com.edevlet.project.usecases.usermanage.entity.FeedBackRequest;
import com.edevlet.project.usecases.usermanage.entity.FeedBackResponse;
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
	HospitalDao hospitalDao;

	@Autowired
	ClinicDao clinicDao;

	@Autowired
	private ManageUserApiService manageUserApiService;

	@PostMapping("/feedBack")
	public FeedBackResponse feedBack(@RequestBody FeedBackRequest request) {
		return manageUserApiService.feedBack(request);
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
