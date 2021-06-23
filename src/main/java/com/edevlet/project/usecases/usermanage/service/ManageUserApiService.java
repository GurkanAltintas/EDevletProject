package com.edevlet.project.usecases.usermanage.service;

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

public interface ManageUserApiService {

	FeedBackResponse feedBack(FeedBackRequest request);

	FetchDiseasesResponse fetchDiseases(FetchDiseasesRequest request);

	FetchRecipesResponse fetchRecipes(FetchRecipesRequest request);

	FetchReportsResponse fetchReports(FetchReportsRequest request);

	FetchVizitsResponse fetchVizits(FetchVizitsRequest request);

	GetAllAnnouncementsResponse getAllAnnouncements();

	GetAllFeedBacksResponse getAllFeedBacks();

	LoginResponse login(LoginRequest request);

	SaveAnnouncementResponse saveAnnouncement(SaveAnnouncementRequest request);

	SaveUserResponse saveUser(SaveUserRequest request);
}
