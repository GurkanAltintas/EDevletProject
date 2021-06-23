package com.edevlet.project.usecases.common.adapter;

public interface RequestToEntityAdapter {

	public <T, R> T convertRequestToEntity(Class<T> desiredType, R request);
}
