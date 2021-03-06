package com.edevlet.project.entity.rest.manageuser;

import java.time.LocalDateTime;

import com.edevlet.project.core.json.LocalDateTimeyyyyMMddHHmmssMinusSeperatedDeserializer;
import com.edevlet.project.core.json.LocalDateTimeyyyyMMddHHmmssMinusSeperatedSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class VizitDTO {

	private String hospitalName;
	private String clinicName;
	private String doctorName;
	private String trackingNumber;
	@JsonSerialize(using = LocalDateTimeyyyyMMddHHmmssMinusSeperatedSerializer.class)
	@JsonDeserialize(using = LocalDateTimeyyyyMMddHHmmssMinusSeperatedDeserializer.class)
	private LocalDateTime vizitDate;

	public String getClinicName() {
		return clinicName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public LocalDateTime getVizitDate() {
		return vizitDate;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public void setVizitDate(LocalDateTime vizitDate) {
		this.vizitDate = vizitDate;
	}

}
