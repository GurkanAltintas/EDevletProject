package com.edevlet.project.usecases.usermanage.service;

import java.util.List;

import com.edevlet.project.usecases.common.entity.user.Announcement;
import com.edevlet.project.usecases.common.entity.user.User;

public interface ManageUserService {

	List<Announcement> getAllAnnouncements();

	User getUserByIdentityNumber(String identityNumber);

	User getUserByUsername(String userName);

	void saveAnnouncement(Announcement convertToAnnouncement);

	void saveUser(User user);
}
