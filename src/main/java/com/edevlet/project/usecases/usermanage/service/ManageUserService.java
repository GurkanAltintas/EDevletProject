package com.edevlet.project.usecases.usermanage.service;

import com.edevlet.project.usecases.common.entity.user.User;

public interface ManageUserService {

	User getUserByUsername(String userName);

	void saveUser(User user);
}
