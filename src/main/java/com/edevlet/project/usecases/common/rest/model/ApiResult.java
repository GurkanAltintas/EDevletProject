package com.edevlet.project.usecases.common.rest.model;

import java.util.List;

public class ApiResult {
	private String code;
	private String detail;
	private List<ApiError> errors;

	public String getCode() {
		return code;
	}

	public String getDetail() {
		return detail;
	}

	public List<ApiError> getErrors() {
		return errors;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setErrors(List<ApiError> errors) {
		this.errors = errors;
	}

}
