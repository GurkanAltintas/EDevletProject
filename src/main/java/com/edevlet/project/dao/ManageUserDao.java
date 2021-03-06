package com.edevlet.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.entity.db.User;

public interface ManageUserDao extends JpaRepository<User, Long> {

	User findByIdentityNumber(String identityNumber);

	User findByUsername(String username);

}
