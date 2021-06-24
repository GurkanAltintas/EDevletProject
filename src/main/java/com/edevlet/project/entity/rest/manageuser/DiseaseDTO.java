package com.edevlet.project.entity.rest.manageuser;

import java.time.LocalDateTime;

import com.edevlet.project.core.json.LocalDateTimeyyyyMMddHHmmssMinusSeperatedDeserializer;
import com.edevlet.project.core.json.LocalDateTimeyyyyMMddHHmmssMinusSeperatedSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class DiseaseDTO {

	@JsonSerialize(using = LocalDateTimeyyyyMMddHHmmssMinusSeperatedSerializer.class)
	@JsonDeserialize(using = LocalDateTimeyyyyMMddHHmmssMinusSeperatedDeserializer.class)
	private LocalDateTime diagnosisDate;

	private String diagnosis;
	private String clinic;

	private String doctor;

	public String getClinic() {
		return clinic;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public LocalDateTime getDiagnosisDate() {
		return diagnosisDate;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setClinic(String clinic) {
		this.clinic = clinic;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public void setDiagnosisDate(LocalDateTime diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

}
