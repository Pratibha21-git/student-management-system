package com.example.sms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.sms.model.Student;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins="http://localhost:5173")
public class StudentController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping
    public ArrayList<Student> getStudent() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(  new Student(1, "Ram", "MCA") );
        students.add(  new Student(2, "Sakshi", "BE") );
        students.add(  new Student(3, "Ritu", "BCA") );

        return students;
    }

    @GetMapping("/bca")
    public List<Student> getBcaStudents(){
        return  getStudent().stream()
                  .filter (student-> "BCA".equals(student.getCourse()))
                  .collect(Collectors.toList());

    }

    @GetMapping("/count")
    public int countStudents(){
        String sql = "SELECT COUNT(*) FROM students";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
  
}