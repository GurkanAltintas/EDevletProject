package com.edevlet.project.usecases.common.rest.model;

public class ApiError {
	private String code;
	private String explanation;

	public String getCode() {
		return code;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

}
