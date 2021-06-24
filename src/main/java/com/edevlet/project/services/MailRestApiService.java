package com.edevlet.project.services;

import com.edevlet.project.entity.rest.mail.SendMailRequest;
import com.edevlet.project.entity.rest.mail.SendMailResponse;

public interface MailRestApiService {

	SendMailResponse sendMail(SendMailRequest request);
}
