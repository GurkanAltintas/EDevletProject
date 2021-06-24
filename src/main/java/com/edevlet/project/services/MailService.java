package com.edevlet.project.services;

import com.edevlet.project.entity.rest.mail.MailRequest;
import com.edevlet.project.entity.rest.mail.MailResponse;

public interface MailService {

	MailResponse sendMail(MailRequest request);
}
