package com.edevlet.project.entity.rest.manageuser;

public class LoginRequest {

	private String loginValue;
	private String password;
	private Integer loginType;

	public Integer getLoginType() {
		return loginType;
	}

	public String getLoginValue() {
		return loginValue;
	}

	public String getPassword() {
		return password;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}

	public void setLoginValue(String loginValue) {
		this.loginValue = loginValue;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
