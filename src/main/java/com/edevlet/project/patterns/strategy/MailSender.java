package com.edevlet.project.patterns.strategy;

import com.edevlet.project.entity.rest.mail.MailRequest;
import com.edevlet.project.entity.rest.mail.MailResponse;

public interface MailSender {
	MailResponse sendMail(MailRequest request);
}
