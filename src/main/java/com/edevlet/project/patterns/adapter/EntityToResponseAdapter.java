package com.edevlet.project.patterns.adapter;

import com.edevlet.project.core.model.AbstractCommonResponse;

public interface EntityToResponseAdapter {

	public <T extends AbstractCommonResponse, K> T convertEntityToResponse(Class<T> desiredResponseType, K entity);
}
