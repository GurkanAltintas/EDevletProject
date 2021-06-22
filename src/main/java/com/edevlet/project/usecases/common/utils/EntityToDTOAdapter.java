package com.edevlet.project.usecases.common.utils;

import com.edevlet.project.usecases.common.entity.user.EntityDTO;
import com.edevlet.project.usecases.common.entity.user.User;

public interface EntityToDTOAdapter {

    EntityDTO adapter(User user);
}
