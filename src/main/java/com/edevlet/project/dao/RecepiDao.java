package com.edevlet.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.entity.db.Recipe;

public interface RecepiDao extends JpaRepository<Recipe, Integer> {

}
