package com.edevlet.project.usecases.mail.service;

import com.edevlet.project.usecases.mail.entity.MailRequest;
import com.edevlet.project.usecases.mail.entity.MailResponse;

public interface MailService {

	MailResponse sendMail(MailRequest request);
}
