package com.edevlet.project.usecases.manageUser.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="user")
public class Login {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;
}
