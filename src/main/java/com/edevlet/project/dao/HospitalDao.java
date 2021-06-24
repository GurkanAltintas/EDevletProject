package com.edevlet.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.entity.db.Hospital;

public interface HospitalDao extends JpaRepository<Hospital, Integer> {

}
