package com.edevlet.project.usecases.common.adapter;

import com.edevlet.project.usecases.common.rest.model.AbstractCommonResponse;

public interface EntityToResponseAdapter {

	public <T extends AbstractCommonResponse, K> T convertEntityToResponse(Class<T> desiredResponseType, K entity);
}
