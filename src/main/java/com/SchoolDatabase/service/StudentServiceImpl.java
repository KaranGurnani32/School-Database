package com.SchoolDatabase.service;

import com.SchoolDatabase.entity.Student;
import com.SchoolDatabase.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        return this.studentRepository.update(student, id);
    }

    @Override
    public Student deleteStudent(Long id) {
        return this.studentRepository.delete(id);
    }
}
