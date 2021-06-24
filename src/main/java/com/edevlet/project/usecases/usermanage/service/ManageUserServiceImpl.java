package com.edevlet.project.usecases.usermanage.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edevlet.project.usecases.common.entity.user.Announcement;
import com.edevlet.project.usecases.common.entity.user.Disease;
import com.edevlet.project.usecases.common.entity.user.Feedback;
import com.edevlet.project.usecases.common.entity.user.Recipe;
import com.edevlet.project.usecases.common.entity.user.Report;
import com.edevlet.project.usecases.common.entity.user.User;
import com.edevlet.project.usecases.common.entity.user.Vizit;
import com.edevlet.project.usecases.usermanage.dao.AnnouncemntRepository;
import com.edevlet.project.usecases.usermanage.dao.DiseaseDao;
import com.edevlet.project.usecases.usermanage.dao.FeedBackDao;
import com.edevlet.project.usecases.usermanage.dao.ManageUserDao;
import com.edevlet.project.usecases.usermanage.dao.RecepiDao;
import com.edevlet.project.usecases.usermanage.dao.ReportDao;
import com.edevlet.project.usecases.usermanage.dao.VizitDao;

@Service
@Transactional
public class ManageUserServiceImpl implements ManageUserService {

	@Autowired
	private ManageUserDao manageUserDao;

	@Autowired
	FeedBackDao feedbackDao;

	@Autowired
	VizitDao vizitDao;

	@Autowired
	AnnouncemntRepository announcemntRepository;

	@Autowired
	ReportDao reportDao;

	@Autowired
	DiseaseDao diseaseDao;

	@Autowired
	RecepiDao recepiDao;

	@Override
	public List<Announcement> getAllAnnouncements() {
		return announcemntRepository.findAll();
	}

	@Override
	public List<Disease> getAllDisease() {
		return diseaseDao.findAll();
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedbackDao.findAll();
	}

	@Override
	public List<Recipe> getAllRecipes() {

		return recepiDao.findAll();
	}

	@Override
	public List<Report> getAllReports() {
		return reportDao.findAll();
	}

	@Override
	public List<User> getAllUsers() {

		return manageUserDao.findAll();
	}

	@Override
	public List<Vizit> getAllVizits() {

		return vizitDao.findAll();
	}

	@Override
	public User getUserByIdentityNumber(String identityNumber) {
		return manageUserDao.findByIdentityNumber(identityNumber);
	}

	@Override
	public User getUserByUsername(String userName) {
		return manageUserDao.findByUsername(userName);
	}

	@Override
	public void saveAnnouncement(Announcement data) {
		announcemntRepository.save(data);
	}

	@Override
	public void saveFeedBack(Feedback entity) {
		feedbackDao.save(entity);
	}

	@Override
	public void saveUser(User user) {
		manageUserDao.save(user);
	}

}
