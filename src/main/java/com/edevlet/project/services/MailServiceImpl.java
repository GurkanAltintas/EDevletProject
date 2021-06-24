package com.edevlet.project.services;

import org.springframework.stereotype.Service;

import com.edevlet.project.entity.rest.mail.MailRequest;
import com.edevlet.project.entity.rest.mail.MailResponse;
import com.edevlet.project.entity.rest.mail.MailType;
import com.edevlet.project.patterns.factory.MailSenderFactory;

@Service
public class MailServiceImpl implements MailService {

	private MailType findMailType(String mailAdress) {
		return mailAdress.contains("gmail.com") ? MailType.GMAIL : MailType.OUTLOOK;
	}

	@Override
	public MailResponse sendMail(MailRequest request) {
		if ("".isEmpty()) {
			return null;
		}
		MailType type = findMailType(request.getMailAdress());
		return MailSenderFactory.createMailSender(type).sendMail(request);
	}

}
