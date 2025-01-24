package com.tajbir.Security.controller;

import com.tajbir.Security.dto.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = List.of(
            new Student(1, "Tom", 90),
            new Student(2, "Harry", 60),
            new Student(3, "Alice", 40)
    );

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/csrf")
    public ResponseEntity<CsrfToken> getCsrfToken(HttpServletRequest request) {
        return ResponseEntity.ok((CsrfToken) request.getAttribute("_csrf"));
    }

    @PostMapping(value = "/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(student);
    }
}
