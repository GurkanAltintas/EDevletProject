package com.edevlet.project.usecases.common.rest.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

	private final static JsonConverter INSTANCE = new JsonConverter();

	public static JsonConverter getInstance() {
		return INSTANCE;
	}

	public <T> T jsonToObject(String content, Class<T> valueType) throws JsonMappingException, JsonProcessingException {
		return (new ObjectMapper()).readValue(content, valueType);
	}

	public String objectToJson(Object response) throws JsonProcessingException {
		return (new ObjectMapper()).writeValueAsString(response);
	}
}
