package com.edevlet.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.entity.db.Vizit;

public interface VizitDao extends JpaRepository<Vizit, Integer> {

}
