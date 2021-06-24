package com.edevlet.project.patterns.adapter;

public interface RequestToEntityAdapter {

	public <T, R> T convertRequestToEntity(Class<T> desiredType, R request);
}
