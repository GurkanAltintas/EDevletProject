package com.edevlet.project.usecases.usermanage.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edevlet.project.usecases.common.entity.user.Announcement;
import com.edevlet.project.usecases.common.entity.user.User;
import com.edevlet.project.usecases.usermanage.dao.AnnouncemntRepository;
import com.edevlet.project.usecases.usermanage.dao.ManageUserDao;

@Service
@Transactional
public class ManageUserServiceImpl implements ManageUserService {

	@Autowired
	private ManageUserDao dao;

	@Autowired
	AnnouncemntRepository announcemntRepository;

	@Override
	public List<Announcement> getAllAnnouncements() {
		return announcemntRepository.findAll();
	}

	@Override
	public User getUserByIdentityNumber(String identityNumber) {
		return dao.findByIdentityNumber(identityNumber);
	}

	@Override
	public User getUserByUsername(String userName) {
		return dao.findByUsername(userName);
	}

	@Override
	public void saveAnnouncement(Announcement data) {
		announcemntRepository.save(data);
	}

	@Override
	public void saveUser(User user) {
		dao.save(user);
	}

}
