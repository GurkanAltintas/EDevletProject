package com.edevlet.project.usecases.manageUser.login.entity;

public class LoginData {

	private boolean canLogin;
	private String code;
	private String detail;

	public String getCode() {
		return code;
	}

	public String getDetail() {
		return detail;
	}

	public boolean isCanLogin() {
		return canLogin;
	}

	public void setCanLogin(boolean canLogin) {
		this.canLogin = canLogin;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
