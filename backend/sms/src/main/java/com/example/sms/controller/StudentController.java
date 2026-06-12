package com.example.sms.controller;

// import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.Map;
// import org.springframework.beans.factory.annotation.Autowired;


import com.example.sms.service.StudentService;
import com.example.sms.model.Student;
import com.example.sms.dto.StudentRequestDTO;
import com.example.sms.dto.StudentResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins="http://localhost:5173")
public class StudentController {

    @Autowired
    private StudentService service;

    // @GetMapping
    // public ArrayList<Student> getStudent() {
    //     ArrayList<Student> students = new ArrayList<>();
    //     students.add(  new Student(1, "Ram", "MCA") );
    //     students.add(  new Student(2, "Sakshi", "BE") );
    //     students.add(  new Student(3, "Ritu", "BCA") );

    //     return students;
    // }

    // @GetMapping("/bca")
    // public List<Student> getBcaStudents(){
    //     return  getStudent().stream()
    //               .filter (student-> "BCA".equals(student.getCourse()))
    //               .collect(Collectors.toList());

    // }

    @GetMapping("/count")
    public int countStudents(){
        return service.getStudentCount();
    }

    @GetMapping("/message")
    public String getMessage(){
        return service.getStudentInfo();
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    // @PostMapping
    // public Student addStudent(@RequestBody Student student){
    //     return service.saveStudent(student);
    // }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id){

        Student student = service.getStudentById(id);
        StudentResponseDTO response = new StudentResponseDTO(
            student.getId(),
            student.getName(),
            student.getCourse()
        );
        return ResponseEntity.ok(response);
       
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentRequestDTO dto){
       Student student = service.addStudent(dto);
       return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody StudentRequestDTO dto){
        Student student = service.updateStudent(id, dto);
        return ResponseEntity.ok(student);
     }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        return ResponseEntity.ok(Map.of("message",service.deleteStudent(id)));
    }

  
}