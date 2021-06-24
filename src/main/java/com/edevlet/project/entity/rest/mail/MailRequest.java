package com.edevlet.project.entity.rest.mail;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "with")
@Getter
public class MailRequest {

	private final String mailAdress;
	private final String topic;
	private final String mailText;
}
