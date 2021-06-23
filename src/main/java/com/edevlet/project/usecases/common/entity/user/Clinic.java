package com.edevlet.project.usecases.common.entity.user;

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
@Table(name = "CLINICS")
@Getter
@Setter
public class Clinic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clinicId;

	@ManyToOne
	@JoinColumn(name = "HospitalId", nullable = false)
	private Hospital hospital;
	private String clinicName;
}
