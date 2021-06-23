package com.edevlet.project.usecases.usermanage.entity;

import java.time.LocalDateTime;

public class VizitDTO {

	private String hospitalName;
	private String clinicName;
	private String doctorName;
	private String trackingNumber;
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
