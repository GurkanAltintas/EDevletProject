package com.edevlet.project.usecases.mail.entity;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "with")
@Getter
public class MailRequest {

	private final String mailAdress;
	private final String topic;
	private final String mailText;
}
