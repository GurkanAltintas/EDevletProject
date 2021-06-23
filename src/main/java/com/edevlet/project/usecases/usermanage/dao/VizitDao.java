package com.edevlet.project.usecases.usermanage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.usecases.common.entity.user.Vizit;

public interface VizitDao extends JpaRepository<Vizit, Integer> {

}
