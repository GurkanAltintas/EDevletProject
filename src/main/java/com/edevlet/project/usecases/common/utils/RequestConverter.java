package com.edevlet.project.usecases.common.utils;

import java.util.List;

import com.edevlet.project.usecases.common.entity.user.Announcement;
import com.edevlet.project.usecases.common.entity.user.User;
import com.edevlet.project.usecases.common.rest.model.ApiError;
import com.edevlet.project.usecases.common.rest.model.ApiStatus;
import com.edevlet.project.usecases.mail.entity.MailResponse;
import com.edevlet.project.usecases.mail.entity.SendMailResponse;
import com.edevlet.project.usecases.usermanage.entity.SaveAnnouncementRequest;
import com.edevlet.project.usecases.usermanage.entity.SaveUserRequest;

public class RequestConverter {

	public static Announcement convertToAnnouncement(SaveAnnouncementRequest request) {
		Announcement obj = new Announcement();
		obj.setAnnouncement(request.getAnnouncement());
		return obj;
	}

	public static SendMailResponse convertToSenMailResponse(MailResponse mailResponse) {

		SendMailResponse sendMailResponse = new SendMailResponse();
		if (!mailResponse.isSuccess()) {
			ApiError apiError = new ApiError();
			apiError.setCode(mailResponse.getErrorCode());
			apiError.setExplanation(mailResponse.getErrorMessage());

			sendMailResponse.getResult().setCode(ApiStatus.EXCEPTION.getCode());
			sendMailResponse.getResult().setErrors(List.of(apiError));
		}

		return sendMailResponse;
	}

	public static User convertToUser(SaveUserRequest request) {
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

	private RequestConverter() {
		throw new IllegalAccessError("utility class");
	}
}
