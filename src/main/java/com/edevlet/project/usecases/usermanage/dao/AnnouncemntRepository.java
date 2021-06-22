package com.edevlet.project.usecases.usermanage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.usecases.common.entity.user.Announcement;

public interface AnnouncemntRepository extends JpaRepository<Announcement, Integer> {

}
