package com.example.sms.service;

import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.sms.model.Student;
import com.example.sms.repository.StudentRepository;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getStudentInfo(){
        return "Service is working";
    }

    public Integer getStudentCount(){
        String sql = "SELECT COUNT(*) FROM students";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }
    public Student saveStudent(Student student){
        return repository.save(student);
    }
}
