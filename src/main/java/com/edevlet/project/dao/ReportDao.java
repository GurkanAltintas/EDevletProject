package com.edevlet.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.entity.db.Report;

public interface ReportDao extends JpaRepository<Report, Integer> {

}
