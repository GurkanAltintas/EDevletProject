package com.edevlet.project.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edevlet.project.entity.rest.mail.SendMailRequest;
import com.edevlet.project.entity.rest.mail.SendMailResponse;
import com.edevlet.project.services.MailRestApiService;

@RestController
@RequestMapping(value = "/api")
public class MailRestController {

	@Autowired
	MailRestApiService mailRestApiService;

	@PostMapping("/sendMail")
	public SendMailResponse login(@RequestBody SendMailRequest request) {
		return mailRestApiService.sendMail(request);
	}

}
