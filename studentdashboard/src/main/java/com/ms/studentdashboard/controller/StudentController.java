package com.ms.studentdashboard.controller;

import com.ms.studentdashboard.model.Student;
import com.ms.studentdashboard.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public Student register(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam String username, @RequestParam String password) {
        Student student =studentService.loginStudent(username, password);

        if(student == null){
            return new ResponseEntity<>("User not found ", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }

    @PostMapping("/application")
    public ResponseEntity createApplication(@RequestParam String username,
                                     @RequestParam String universityName,
                                     @RequestParam String course) {
        Student student = studentService.getStudent(username);

        if(student == null){
            return new ResponseEntity<>("User not found ", HttpStatus.NOT_FOUND);
        }else{
            Student studentApp =studentService.createApplication(student, universityName, course);
            return new ResponseEntity<>(studentApp, HttpStatus.OK);
        }
    }
}
