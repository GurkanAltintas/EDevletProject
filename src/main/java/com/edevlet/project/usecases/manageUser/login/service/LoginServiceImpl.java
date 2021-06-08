package com.edevlet.project.usecases.manageUser.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edevlet.project.usecases.common.entity.user.User;
import com.edevlet.project.usecases.manageUser.login.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao dao;

	@Override
	public User getUserByUsername(String userName) {
		return dao.findByUsername(userName);
	}

}
