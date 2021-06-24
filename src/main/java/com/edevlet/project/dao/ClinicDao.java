package com.edevlet.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.entity.db.Clinic;

public interface ClinicDao extends JpaRepository<Clinic, Integer> {

}
