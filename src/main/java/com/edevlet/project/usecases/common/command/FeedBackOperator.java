package com.edevlet.project.usecases.common.command;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedBackOperator {

	private String message;

	public void check() {
		this.message = new String(this.message.toLowerCase().getBytes(StandardCharsets.UTF_8));
	}

	public void save() {
		String str = message.toUpperCase(Locale.ENGLISH);
		this.message = str;
	}
}
