package com.edevlet.project.usecases.mail.entity;

public class SendMailRequest {

	private String mailAdress;
	private String topic;
	private String text;

	public String getMailAdress() {
		return mailAdress;
	}

	public String getText() {
		return text;
	}

	public String getTopic() {
		return topic;
	}

	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}
