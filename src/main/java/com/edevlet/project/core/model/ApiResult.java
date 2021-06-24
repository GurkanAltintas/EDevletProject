package com.edevlet.project.core.model;

import java.util.ArrayList;
import java.util.List;

public class ApiResult {
	private String code = ApiStatus.SUCCESS.getCode();
	private String detail = "SUCCESS";
	private List<ApiError> errors = new ArrayList<>();

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
