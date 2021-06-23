package com.edevlet.project.usecases.usermanage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.usecases.common.entity.user.Report;

public interface ReportDao extends JpaRepository<Report, Integer> {

}
