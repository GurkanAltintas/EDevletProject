package com.edevlet.project.core.json;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LocalDateTimeyyyyMMddHHmmssMinusSeperatedSerializer extends StdSerializer<LocalDateTime> {

	private static final long serialVersionUID = 1L;

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public LocalDateTimeyyyyMMddHHmmssMinusSeperatedSerializer() {
		super(LocalDateTime.class);
	}

	@Override
	public void serialize(LocalDateTime value, JsonGenerator generator, SerializerProvider provider)
			throws IOException {
		generator.writeString(value.format(formatter));
	}
}
