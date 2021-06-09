package com.edevlet.project.usecases.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edevlet.project.usecases.common.utils.RequestConverter;
import com.edevlet.project.usecases.common.utils.RequestValidator;
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

	@Override
	public SendMailResponse sendMail(SendMailRequest request) {
		RequestValidator.validateSendMailRequest(request);
		MailResponse mailResponse = mailService.sendMail(convertToMailRequest(request));
		return RequestConverter.convertToSenMailResponse(mailResponse);
	}

}
