package com.edevlet.project.usecases.mail.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
public class MailResponse {

	private final boolean success;
	private final String errorCode;
	private final String errorMessage;

}
