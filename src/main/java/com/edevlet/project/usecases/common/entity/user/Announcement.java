package com.edevlet.project.usecases.common.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Announcements")
@Getter
@Setter
public class Announcement {

	@Id
	@GeneratedValue
	private Integer id;
	private String announcement;

}
