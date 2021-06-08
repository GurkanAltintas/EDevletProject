package com.edevlet.project.usecases.mail.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edevlet.project.usecases.common.rest.model.ApiError;
import com.edevlet.project.usecases.common.rest.model.ApiStatus;
import com.edevlet.project.usecases.mail.entity.MailRequest;
import com.edevlet.project.usecases.mail.entity.MailResponse;
import com.edevlet.project.usecases.mail.entity.SendMailRequest;
import com.edevlet.project.usecases.mail.entity.SendMailResponse;

@Service
public class MailRestApiServiceImpl implements MailRestApiService {

	@Autowired
	MailService mailService;

	private MailRequest convertToMailRequest(SendMailRequest request) {

		return MailRequest.builder().withMailAdress(request.getMailAdress()).withMailText(request.getText())
				.withTopic(request.getTopic()).build();
	}

	private SendMailResponse convertToSenMailResponse(MailResponse mailResponse) {

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

	@Override
	public SendMailResponse sendMail(SendMailRequest request) {
		validateRequest(request);

		MailResponse mailResponse = mailService.sendMail(convertToMailRequest(request));

		return convertToSenMailResponse(mailResponse);
	}

	private void validateRequest(SendMailRequest request) {
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

}
