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
@Table(name = "VIZITS")
@Getter
@Setter
public class Vizit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vizitId;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	@ManyToOne
	@JoinColumn(name = "HospitalId")
	private Hospital hospital;
	@ManyToOne
	@JoinColumn(name = "ClinicId")
	private Clinic clinic;
	private LocalDateTime vizitDate;
	private String trackingNumber;
	@ManyToOne
	@JoinColumn(name = "DoctorId")
	private Doctor doctor;
}
