package com.edevlet.project.usecases.usermanage.service;

import com.edevlet.project.usecases.usermanage.entity.GetAllAnnouncementsResponse;
import com.edevlet.project.usecases.usermanage.entity.LoginRequest;
import com.edevlet.project.usecases.usermanage.entity.LoginResponse;
import com.edevlet.project.usecases.usermanage.entity.SaveAnnouncementRequest;
import com.edevlet.project.usecases.usermanage.entity.SaveAnnouncementResponse;
import com.edevlet.project.usecases.usermanage.entity.SaveUserRequest;
import com.edevlet.project.usecases.usermanage.entity.SaveUserResponse;

public interface ManageUserApiService {

	GetAllAnnouncementsResponse getAllAnnouncements();

	LoginResponse login(LoginRequest request);

	SaveAnnouncementResponse saveAnnouncement(SaveAnnouncementRequest request);

	SaveUserResponse saveUser(SaveUserRequest request);
}
