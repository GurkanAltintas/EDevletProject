package com.edevlet.project.usecases.common.entity.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "HOSPITALS")
@Getter
@Setter
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HospitalId")
	private Integer hospitalId;
	private String hospitalName;
	@OneToMany(mappedBy = "hospital")
	private List<Clinic> clinics;
}
