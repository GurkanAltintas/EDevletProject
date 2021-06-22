package com.edevlet.project.usecases.common.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class EntityDTO {

    private String name;

    private String surname;

    private String identityNumber;

    private String mailAdress;

    private String phoneNumber;
}
