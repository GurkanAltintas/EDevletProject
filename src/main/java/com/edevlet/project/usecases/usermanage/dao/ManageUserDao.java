package com.edevlet.project.usecases.usermanage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.usecases.common.entity.user.User;

public interface ManageUserDao extends JpaRepository<User, Long> {

	User findByIdentityNumber(String identityNumber);

	User findByUsername(String username);

}
