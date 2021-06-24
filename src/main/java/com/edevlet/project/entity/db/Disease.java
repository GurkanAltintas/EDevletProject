package com.edevlet.project.entity.db;

import java.time.LocalDateTime;

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
@Table(name = "Diseases")
@Getter
@Setter
public class Disease {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer diseaseId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	private LocalDateTime diagnosisDate;
	private String diagnosis;

	@ManyToOne
	@JoinColumn(name = "Clinic")
	Clinic clinic;

	@ManyToOne
	@JoinColumn(name = "Doctor")
	Doctor doctor;

}
