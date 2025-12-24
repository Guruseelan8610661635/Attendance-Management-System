package com.attendance.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.attendance.model.Student;
import com.attendance.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student add(@RequestBody Student s) {
        return service.save(s);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }
}
