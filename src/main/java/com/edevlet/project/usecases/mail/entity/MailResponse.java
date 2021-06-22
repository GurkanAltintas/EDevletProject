package com.edevlet.project.usecases.mail.entity;

import com.edevlet.project.usecases.common.entity.user.BaseEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
public class MailResponse extends BaseEntity {

	private final boolean success;
	private final String errorCode;
	private final String errorMessage;

}
