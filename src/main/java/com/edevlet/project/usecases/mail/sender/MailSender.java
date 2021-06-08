package com.edevlet.project.usecases.mail.sender;

import com.edevlet.project.usecases.mail.entity.MailRequest;
import com.edevlet.project.usecases.mail.entity.MailResponse;

public interface MailSender {
	MailResponse sendMail(MailRequest request);
}
