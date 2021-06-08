package com.edevlet.project.usecases.manageUser.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.usecases.common.entity.user.User;

public interface LoginDao extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
