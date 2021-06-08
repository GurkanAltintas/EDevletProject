package com.edevlet.project.usecases.mail.service;

import com.edevlet.project.usecases.mail.entity.SendMailRequest;
import com.edevlet.project.usecases.mail.entity.SendMailResponse;

public interface MailRestApiService {

	SendMailResponse sendMail(SendMailRequest request);
}
