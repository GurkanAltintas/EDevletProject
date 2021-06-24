package com.edevlet.project.usecases.common.observer;

import com.edevlet.project.usecases.mail.entity.MailRequest;
import com.edevlet.project.usecases.mail.service.MailService;
import com.edevlet.project.usecases.usermanage.service.ManageUserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AnnouncmentObserver implements Observer {

	private static final String MAIL_TOPIC = "NEW ANNOUNCTMENT FROM E NABIZ";

	ManageUserService manageUserService;
	MailService mailService;

	@Override
	public void update(Observable observable) {
		AnnouncmentObservable obs = (AnnouncmentObservable) observable;

		manageUserService.getAllUsers().forEach(f -> {

			mailService.sendMail(MailRequest.builder().withMailAdress(f.getMailAdress())
					.withMailText(obs.getNewAnnouncment()).withTopic(MAIL_TOPIC).build());
		});
	}

}
