package com.edevlet.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edevlet.project.entity.db.Feedback;

public interface FeedBackDao extends JpaRepository<Feedback, Integer> {

}
