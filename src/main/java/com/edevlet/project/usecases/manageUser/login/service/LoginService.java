package com.edevlet.project.usecases.manageUser.login.service;

import com.edevlet.project.usecases.common.entity.user.User;

public interface LoginService {

	User getUserByUsername(String userName);
}
