package com.edevlet.project.entity.db;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Reports")
@Getter
@Setter
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reportId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	private LocalDate reportDate;
	private String reportNumber;
	private String reportTrackingNumber;
	private String reportType;
	private LocalDate startDate;
	private LocalDate endDate;
	private String diagnosis;
}
