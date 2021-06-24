package com.edevlet.project.usecases.mail.service;

import org.springframework.stereotype.Service;

import com.edevlet.project.usecases.mail.entity.MailRequest;
import com.edevlet.project.usecases.mail.entity.MailResponse;
import com.edevlet.project.usecases.mail.entity.MailType;
import com.edevlet.project.usecases.mail.factory.MailSenderFactory;

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
