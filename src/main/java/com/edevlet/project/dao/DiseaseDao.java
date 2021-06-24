package com.edevlet.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.entity.db.Disease;

public interface DiseaseDao extends JpaRepository<Disease, Integer> {

}
