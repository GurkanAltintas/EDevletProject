package com.edevlet.project.usecases.manageUser.login.service;

import com.edevlet.project.usecases.manageUser.login.entity.LoginRequest;
import com.edevlet.project.usecases.manageUser.login.entity.LoginResponse;

public interface LoginApiService {

	LoginResponse login(LoginRequest request);
}
