package com.edevlet.project.usecases.usermanage.entity;

import java.time.LocalDate;

import com.edevlet.project.usecases.common.rest.json.LocalDateyyyyMMddDeserializer;
import com.edevlet.project.usecases.common.rest.json.LocalDateyyyyMMddSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ReportDTO {
	@JsonSerialize(using = LocalDateyyyyMMddSerializer.class)
	@JsonDeserialize(using = LocalDateyyyyMMddDeserializer.class)
	private LocalDate reportDate;
	private String reportNumber;
	private String reportTrackingNumber;
	private String reportType;
	@JsonSerialize(using = LocalDateyyyyMMddSerializer.class)
	@JsonDeserialize(using = LocalDateyyyyMMddDeserializer.class)
	private LocalDate startDate;
	@JsonSerialize(using = LocalDateyyyyMMddSerializer.class)
	@JsonDeserialize(using = LocalDateyyyyMMddDeserializer.class)
	private LocalDate endDate;
	private String diagnosis;

	public String getDiagnosis() {
		return diagnosis;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public LocalDate getReportDate() {
		return reportDate;
	}

	public String getReportNumber() {
		return reportNumber;
	}

	public String getReportTrackingNumber() {
		return reportTrackingNumber;
	}

	public String getReportType() {
		return reportType;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setReportDate(LocalDate reportDate) {
		this.reportDate = reportDate;
	}

	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}

	public void setReportTrackingNumber(String reportTrackingNumber) {
		this.reportTrackingNumber = reportTrackingNumber;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

}
