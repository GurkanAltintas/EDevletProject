package com.edevlet.project.usecases.usermanage.service;

import java.util.List;

import com.edevlet.project.usecases.common.entity.user.Announcement;
import com.edevlet.project.usecases.common.entity.user.Disease;
import com.edevlet.project.usecases.common.entity.user.Feedback;
import com.edevlet.project.usecases.common.entity.user.Recipe;
import com.edevlet.project.usecases.common.entity.user.Report;
import com.edevlet.project.usecases.common.entity.user.User;
import com.edevlet.project.usecases.common.entity.user.Vizit;

public interface ManageUserService {

	List<Announcement> getAllAnnouncements();

	List<Disease> getAllDisease();

	List<Feedback> getAllFeedbacks();

	List<Recipe> getAllRecipes();

	List<Report> getAllReports();

	List<Vizit> getAllVizits();

	User getUserByIdentityNumber(String identityNumber);

	User getUserByUsername(String userName);

	void saveAnnouncement(Announcement convertToAnnouncement);

	void saveFeedBack(Feedback entity);

	void saveUser(User user);
}
