package com.edevlet.project.usecases.usermanage.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edevlet.project.usecases.common.entity.user.User;
import com.edevlet.project.usecases.usermanage.dao.ManageUserDao;

@Service
@Transactional
public class ManageUserServiceImpl implements ManageUserService {

	@Autowired
	private ManageUserDao dao;

	@Override
	public User getUserByUsername(String userName) {
		return dao.findByUsername(userName);
	}

	@Override
	public void saveUser(User user) {
		dao.save(user);
	}

}
