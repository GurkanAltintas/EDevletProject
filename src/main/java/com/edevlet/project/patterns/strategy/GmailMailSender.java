package com.edevlet.project.patterns.strategy;

import java.util.Properties;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.edevlet.project.entity.rest.mail.MailRequest;
import com.edevlet.project.entity.rest.mail.MailResponse;

public class GmailMailSender implements MailSender {

	@Override
	public MailResponse sendMail(MailRequest request) {

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setDefaultEncoding("UTF-8");
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("oguztklu@gmail.com");
		mailSender.setPassword("oguzz0633");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		MimeMessagePreparator preparator = mimeMessage -> {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			mimeMessageHelper.setFrom("oguztklu@gmail.com");
			mimeMessageHelper.setTo(request.getMailAdress());
			mimeMessageHelper.setSubject(request.getTopic());
			mimeMessageHelper.setText(request.getMailText());

		};

		try {
			mailSender.send(preparator);
			return MailResponse.builder().withSuccess(true).build();

		} catch (Exception ex) {
			return MailResponse.builder().withSuccess(false).withErrorCode(ex.getMessage())
					.withErrorMessage(ExceptionUtils.getStackTrace(ex)).build();
		}
	}

}
