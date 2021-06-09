package com.edevlet.project.usecases.usermanage.service;

import com.edevlet.project.usecases.usermanage.entity.LoginRequest;
import com.edevlet.project.usecases.usermanage.entity.LoginResponse;
import com.edevlet.project.usecases.usermanage.entity.SaveUserRequest;
import com.edevlet.project.usecases.usermanage.entity.SaveUserResponse;

public interface ManageUserApiService {

	LoginResponse login(LoginRequest request);

	SaveUserResponse saveUser(SaveUserRequest request);
}
