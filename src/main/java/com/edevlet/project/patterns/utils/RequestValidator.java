package com.edevlet.project.patterns.utils;

import org.apache.commons.lang3.StringUtils;

import com.edevlet.project.entity.rest.mail.SendMailRequest;
import com.edevlet.project.entity.rest.manageuser.LoginRequest;
import com.edevlet.project.entity.rest.manageuser.SaveUserRequest;

public class RequestValidator {

	public static void validateLoginRequest(LoginRequest request) {
		if (StringUtils.isEmpty(request.getLoginValue())) {
			throw new RuntimeException("Empty field: " + "UserName");
		}

		if (StringUtils.isEmpty(request.getPassword())) {
			throw new RuntimeException("Empty field: " + "Password");
		}

	}

	public static void validateSaveUserRequest(SaveUserRequest request) {
		if (StringUtils.isEmpty(request.getIdentityNumber())) {
			throw new RuntimeException("Empty field: " + "IdentityNumber");
		}

		if (StringUtils.isEmpty(request.getMailAdress())) {
			throw new RuntimeException("Empty field: " + "MailAdress");
		}

		if (StringUtils.isEmpty(request.getUsername())) {
			throw new RuntimeException("Empty field: " + "UserName");
		}

		if (StringUtils.isEmpty(request.getPassword())) {
			throw new RuntimeException("Empty field: " + "Password");
		}

		if (StringUtils.isEmpty(request.getName())) {
			throw new RuntimeException("Empty field: " + "Name");
		}

		if (StringUtils.isEmpty(request.getSurname())) {
			throw new RuntimeException("Empty field: " + "Surname");
		}
	}

	public static void validateSendMailRequest(SendMailRequest request) {
		if (StringUtils.isEmpty(request.getMailAdress())) {
			throw new RuntimeException("mail adress is empty");
		}

		if (StringUtils.isEmpty(request.getText())) {
			throw new RuntimeException("mail text is empty");
		}

		if (StringUtils.isEmpty(request.getTopic())) {
			throw new RuntimeException("mail topic is empty");
		}

	}

	private RequestValidator() {
		throw new IllegalAccessError("utility class");
	}
}
