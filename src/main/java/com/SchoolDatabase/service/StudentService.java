package com.SchoolDatabase.service;

import com.SchoolDatabase.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Optional<Student> getStudentById(Long id);

    Student updateStudent(Student student, Long id);

    Student deleteStudent(Long id);
}
