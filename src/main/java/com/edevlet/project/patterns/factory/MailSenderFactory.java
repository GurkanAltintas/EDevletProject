package com.edevlet.project.patterns.factory;

import java.util.EnumMap;
import java.util.Map;

import com.edevlet.project.entity.rest.mail.MailType;
import com.edevlet.project.patterns.strategy.GmailMailSender;
import com.edevlet.project.patterns.strategy.MailSender;
import com.edevlet.project.patterns.strategy.OutlookMailSender;

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
