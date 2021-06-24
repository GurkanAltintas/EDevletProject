package com.edevlet.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.entity.db.Announcement;

public interface AnnouncemntRepository extends JpaRepository<Announcement, Integer> {

}
