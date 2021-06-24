package com.edevlet.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edevlet.project.entity.rest.mail.MailRequest;
import com.edevlet.project.entity.rest.mail.MailResponse;
import com.edevlet.project.entity.rest.mail.SendMailRequest;
import com.edevlet.project.entity.rest.mail.SendMailResponse;
import com.edevlet.project.patterns.adapter.EntityToResponseAdapterImpl;
import com.edevlet.project.patterns.utils.RequestValidator;

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
		return new EntityToResponseAdapterImpl().convertEntityToResponse(SendMailResponse.class, mailResponse);
		// return RequestConverter.convertToSenMailResponse(mailResponse);
	}

}
