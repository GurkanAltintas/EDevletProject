package com.edevlet.project.usecases.common.rest.model;

public abstract class AbstractCommonResponse {

	private ApiResult result;
	private Object data;

	public Object getData() {
		return data;
	}

	public ApiResult getResult() {
		return result;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setResult(ApiResult result) {
		this.result = result;
	}

}
