package com.edevlet.project.core.model;

public abstract class AbstractCommonResponse {

	private ApiResult result = new ApiResult();
	private Object data = null;

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
