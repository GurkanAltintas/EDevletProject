package com.edevlet.project.services;

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

public interface ManageUserRestApiService {

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
