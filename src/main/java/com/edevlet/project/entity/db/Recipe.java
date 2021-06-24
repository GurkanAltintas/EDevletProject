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
@Table(name = "RECIPES")
@Getter
@Setter
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recepiId;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	private LocalDateTime recepiDate;
	private String recepiNumber;
	private String recepiType;
	@ManyToOne
	@JoinColumn(name = "RecepiDoctor")
	private Doctor doctor;
}
