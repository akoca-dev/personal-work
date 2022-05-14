package com.akoca.noteservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

    private static final ObjectMapper GENERAL_OBJECT_MAPPER = new ObjectMapper();

    public static Optional<String> objectToJson(Object object) {
        try {
            return Optional.of(GENERAL_OBJECT_MAPPER.writeValueAsString(object));
        } catch (Exception e) {
            LOGGER.error("Object-to-json conversion failed.\nMessage: {}\nEx: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }
}
