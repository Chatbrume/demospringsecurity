package eu.ensup.demospringsecurity.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class JsonConverter
{
    public static ObjectMapper getMapper()
    {
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS);
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        mapper.disable(DeserializationFeature.UNWRAP_ROOT_VALUE);

        return mapper;
    }

    public static List<Student> convertJsonFileToStudents(String filename) throws IOException {
        ObjectMapper mapper = getMapper();
        return mapper.readValue(JsonConverter.class.getClassLoader().getResource(filename), new TypeReference<List<Student>>(){});
    }

    public static List<Student> convertJsonToStudents(String json) throws JsonProcessingException {
        ObjectMapper mapper = getMapper();
        return mapper.readValue(json, new TypeReference<List<Student>>(){});
    }

    public static Student convertJsonToStudent(String json) throws JsonProcessingException {
        ObjectMapper mapper = getMapper();
        return mapper.readValue(json, Student.class);
    }

    public static String convertStudentToJson(Student student) throws JsonProcessingException {
        ObjectMapper mapper = getMapper();
        return mapper.writeValueAsString(student);
    }
}
