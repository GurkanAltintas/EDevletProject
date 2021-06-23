package com.edevlet.project.usecases.usermanage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.usecases.common.entity.user.Recipe;

public interface RecepiDao extends JpaRepository<Recipe, Integer> {

}
