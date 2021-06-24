package com.edevlet.project.core.json;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateTimeyyyyMMddHHmmssMinusSeperatedDeserializer extends StdDeserializer<LocalDateTime> {

	private static final long serialVersionUID = 1L;

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	protected LocalDateTimeyyyyMMddHHmmssMinusSeperatedDeserializer() {
		super(LocalDateTime.class);
	}

	@Override
	public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		return LocalDateTime.parse(parser.readValueAs(String.class), formatter);
	}
}
