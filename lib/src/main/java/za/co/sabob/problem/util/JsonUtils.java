package za.co.sabob.problem.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.Optional;
import java.util.TimeZone;
import java.util.logging.Logger;

public class JsonUtils {

    static final Logger LOG = Logger.getLogger(JsonUtils.class.getName());

    static ObjectMapper mapper = createLenientMapper();

    public static final <T> Optional<T> toObjectQuietly(String strJSON, TypeReference<T> valueTypeRef) {
        return toObjectQuietly(strJSON, valueTypeRef, mapper);
    }

    public static final <T> Optional<T> toObjectQuietly(String strJSON, TypeReference<T> valueTypeRef, ObjectMapper mapper) {

        try {
            T obj = mapper.readValue(strJSON, valueTypeRef);
            return Optional.ofNullable(obj);

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static final <T> Optional<T> toObject(String strJSON, TypeReference<T> valueTypeRef) {
        return toObject(strJSON, valueTypeRef, mapper);
    }

    public static final <T> Optional<T> toObject(String strJSON, TypeReference<T> valueTypeRef, ObjectMapper mapper) {

        try {
            T obj = mapper.readValue(strJSON, valueTypeRef);
            return Optional.ofNullable(obj);

        } catch (Exception e) {
            String msg = "Exception (toObject)" + "\r\n" + strJSON + "\r\n" + e.getMessage() + "\r\n" + ExceptionUtils.getStackTrace(e);
            LOG.info(msg);
            return Optional.empty();
        }
    }

    public static final <T> Optional<T> toObjectQuietly(String strJSON, Class<T> c) {
        return toObjectQuietly(strJSON, c, mapper);
    }

    public static final <T> Optional<T> toObjectQuietly(String strJSON, Class<T> c, ObjectMapper mapper) {

        try {
            T obj = mapper.readValue(strJSON, c);
            return Optional.ofNullable(obj);

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static final <T> Optional<T> toObject(String strJSON, Class<T> c) {
        return toObject(strJSON, c, mapper);
    }

    public static final <T> Optional<T> toObject(String strJSON, Class<T> c, ObjectMapper mapper) {

        try {
            T obj = mapper.readValue(strJSON, c);
            return Optional.ofNullable(obj);

        } catch (Exception e) {
            String msg = "Exception (toObject)" + "\r\n" + strJSON + "\r\n" + e.getMessage() + "\r\n" + ExceptionUtils.getStackTrace(e);
            LOG.info(msg);
            return Optional.empty();
        }
    }

    public static final Optional<String> toJsonQuietly(Object obj) {
        return toJsonQuietly(obj, mapper);
    }

    public static final Optional<String> toJsonQuietly(Object obj, ObjectMapper mapper) {

        try {
            String json = mapper.writeValueAsString(obj);
            return Optional.ofNullable(json);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static final Optional<String> toJson(Object obj) {
        return toJson(obj, mapper);
    }

    public static final Optional<String> toJson(Object obj, ObjectMapper mapper) {

        try {
            String json = mapper.writeValueAsString(obj);
            return Optional.ofNullable(json);

        } catch (Exception e) {
            String msg = "Exception (toJson)" + "\r\n" + obj + "\r\n" + e.getMessage() + "\r\n" + ExceptionUtils.getStackTrace(e);
            LOG.info(msg);
            return Optional.empty();
        }
    }

    public static final Optional<String> prettifyJson(String json) {
        Optional<Object> obj = toObject(json, Object.class, mapper);
        if (obj.isPresent()) {
            return toJson(obj.get());
        }
        return Optional.empty();
    }

    public static ObjectMapper createLenientMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new StdDateFormat());
        TimeZone timezone = TimeZone.getDefault();
        mapper.setTimeZone(timezone);
        mapper.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
        mapper = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper = mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper = mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper = mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
