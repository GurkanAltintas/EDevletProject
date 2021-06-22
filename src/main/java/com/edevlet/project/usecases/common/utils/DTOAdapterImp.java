package com.edevlet.project.usecases.common.utils;

import com.edevlet.project.usecases.common.entity.user.DTOable;
import com.edevlet.project.usecases.common.entity.user.EntityDTO;
import com.edevlet.project.usecases.common.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class DTOAdapterImp implements EntityToDTOAdapter{



    @Override
    public EntityDTO adapter(User user) {

        EntityDTO entityDTO=new EntityDTO();

        entityDTO.setName(user.getName());
        entityDTO.setSurname(user.getSurname());
        entityDTO.setPhoneNumber(user.getPhoneNumber());
        entityDTO.setMailAdress(user.getMailAdress());
        entityDTO.setIdentityNumber(user.getIdentityNumber());

        return entityDTO;
    }
}
