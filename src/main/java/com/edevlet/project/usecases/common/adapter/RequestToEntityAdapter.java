package com.edevlet.project.usecases.common.adapter;

import com.edevlet.project.usecases.common.entity.user.BaseEntity;

public interface RequestToEntityAdapter {

	public <T extends BaseEntity, R> T convertRequestToEntity(Class<T> desiredType, R request);
}
