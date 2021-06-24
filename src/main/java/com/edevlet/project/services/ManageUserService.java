package com.edevlet.project.services;

import java.util.List;

import com.edevlet.project.entity.db.Announcement;
import com.edevlet.project.entity.db.Disease;
import com.edevlet.project.entity.db.Feedback;
import com.edevlet.project.entity.db.Recipe;
import com.edevlet.project.entity.db.Report;
import com.edevlet.project.entity.db.User;
import com.edevlet.project.entity.db.Vizit;

public interface ManageUserService {

	List<Announcement> getAllAnnouncements();

	List<Disease> getAllDisease();

	List<Feedback> getAllFeedbacks();

	List<Recipe> getAllRecipes();

	List<Report> getAllReports();

	List<User> getAllUsers();

	List<Vizit> getAllVizits();

	User getUserByIdentityNumber(String identityNumber);

	User getUserByUsername(String userName);

	void saveAnnouncement(Announcement convertToAnnouncement);

	void saveFeedBack(Feedback entity);

	void saveUser(User user);
}
