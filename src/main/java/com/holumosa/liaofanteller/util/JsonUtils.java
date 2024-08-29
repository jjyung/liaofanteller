package com.holumosa.liaofanteller.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Map;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    static {
        // 確保使用 UTF-8 編碼
        objectMapper.getFactory().setCharacterEscapes(null);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.getFactory().setCodec(objectMapper);
    }

    public static <T> T parse(String jsonString, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T convert(Map map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }

    public static String toJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
