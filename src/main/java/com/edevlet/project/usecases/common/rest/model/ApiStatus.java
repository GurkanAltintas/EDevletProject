package com.edevlet.project.usecases.common.rest.model;

public enum ApiStatus {

	SUCCESS("0000"), EXCEPTION("1000");

	private String code;

	ApiStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
}
