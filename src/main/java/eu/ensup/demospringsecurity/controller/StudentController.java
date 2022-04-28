package eu.ensup.demospringsecurity.controller;

import eu.ensup.demospringsecurity.domain.JsonConverter;
import eu.ensup.demospringsecurity.domain.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/student")
public class StudentController
{
    private static Logger LOGGER = LogManager.getLogger();
    private static String PATH = "listStudent.json";

    @GetMapping("/")
    public List<Student> getStudents()
    {
        List<Student> students = new ArrayList<>();
        try {
            students = JsonConverter.convertJsonFileToStudents(PATH);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return students;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id)
    {
        List<Student> students = new ArrayList<>();
        try {
            students = JsonConverter.convertJsonFileToStudents(PATH);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return students.stream().filter(e -> e.getId() == id).findAny().orElse(null);
    }
}
