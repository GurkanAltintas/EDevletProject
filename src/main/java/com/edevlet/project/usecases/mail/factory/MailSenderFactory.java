package com.edevlet.project.usecases.mail.factory;

import java.util.EnumMap;
import java.util.Map;

import com.edevlet.project.usecases.mail.entity.MailType;
import com.edevlet.project.usecases.mail.sender.GmailMailSender;
import com.edevlet.project.usecases.mail.sender.MailSender;
import com.edevlet.project.usecases.mail.sender.OutlookMailSender;

public class MailSenderFactory {

	public static MailSender createMailSender(MailType type) {

		Map<MailType, MailSender> map = new EnumMap<>(MailType.class);
		map.put(MailType.GMAIL, new GmailMailSender());
		map.put(MailType.OUTLOOK, new OutlookMailSender());

		return map.getOrDefault(type, new GmailMailSender());
	}

	private MailSenderFactory() {
		throw new IllegalAccessError("factory class");
	}

}
