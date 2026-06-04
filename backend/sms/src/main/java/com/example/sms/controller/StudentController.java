package com.example.sms.controller;
import com.example.sms.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @GetMapping
    public Student getStudent() {
        return new Student(1, "John Doe", "Computer Science");
    }

}
