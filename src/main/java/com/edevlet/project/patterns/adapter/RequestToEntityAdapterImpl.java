package com.edevlet.project.patterns.adapter;

import com.edevlet.project.entity.db.Announcement;
import com.edevlet.project.entity.db.User;
import com.edevlet.project.entity.rest.manageuser.SaveAnnouncementRequest;
import com.edevlet.project.entity.rest.manageuser.SaveUserRequest;

public class RequestToEntityAdapterImpl implements RequestToEntityAdapter {

	@SuppressWarnings("unchecked")
	@Override
	public <T, R> T convertRequestToEntity(Class<T> desiredType, R request) {

		if (Announcement.class.isAssignableFrom(desiredType) && request instanceof SaveAnnouncementRequest) {
			return (T) convertToAnnouncement((SaveAnnouncementRequest) request);
		}

		if (User.class.isAssignableFrom(desiredType) && request instanceof SaveUserRequest) {
			return (T) convertToUser((SaveUserRequest) request);
		}

		return null;
	}

	private Announcement convertToAnnouncement(SaveAnnouncementRequest request) {
		Announcement obj = new Announcement();
		obj.setAnnouncement(request.getAnnouncement());
		return obj;
	}

	private User convertToUser(SaveUserRequest request) {
		User user = new User();
		user.setIdentityNumber(request.getIdentityNumber());
		user.setMailAdress(request.getMailAdress());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setSurname(request.getSurname());
		user.setUsername(request.getUsername());
		return user;
	}
}
