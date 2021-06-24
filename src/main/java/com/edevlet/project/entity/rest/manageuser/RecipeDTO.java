package com.edevlet.project.entity.rest.manageuser;

import java.time.LocalDateTime;

import com.edevlet.project.core.json.LocalDateTimeyyyyMMddHHmmssMinusSeperatedDeserializer;
import com.edevlet.project.core.json.LocalDateTimeyyyyMMddHHmmssMinusSeperatedSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class RecipeDTO {

	@JsonSerialize(using = LocalDateTimeyyyyMMddHHmmssMinusSeperatedSerializer.class)
	@JsonDeserialize(using = LocalDateTimeyyyyMMddHHmmssMinusSeperatedDeserializer.class)
	private LocalDateTime recepiDate;
	private String recepiNumber;
	private String recepiType;
	private String doctor;

	public String getDoctor() {
		return doctor;
	}

	public LocalDateTime getRecepiDate() {
		return recepiDate;
	}

	public String getRecepiNumber() {
		return recepiNumber;
	}

	public String getRecepiType() {
		return recepiType;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public void setRecepiDate(LocalDateTime recepiDate) {
		this.recepiDate = recepiDate;
	}

	public void setRecepiNumber(String recepiNumber) {
		this.recepiNumber = recepiNumber;
	}

	public void setRecepiType(String recepiType) {
		this.recepiType = recepiType;
	}

}
