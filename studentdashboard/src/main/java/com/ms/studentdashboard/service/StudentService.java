package com.ms.studentdashboard.service;

import com.ms.studentdashboard.model.Student;
import com.ms.studentdashboard.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student loginStudent(String username, String password) {
        Student student = studentRepository.findByUsername(username);
        if (student != null && student.getPassword().equals(password)) {
            return student;
        }
        return null;
    }

    public Student getStudent(String username) {
        Student student = studentRepository.findByUsername(username);
        if (student != null) {
            return student;
        }
        return null;
    }

    public Student createApplication(Student student, String universityName, String course) {
        student.setUniversityName(universityName);
        student.setCourse(course);
        return studentRepository.save(student);
    }
}
