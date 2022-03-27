package com.SchoolDatabase.controller;

import com.SchoolDatabase.entity.Student;
import com.SchoolDatabase.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("students")
    public ResponseEntity<?> getAllStudents() {
        List<Student> students = studentService.getAllStudents();

        if(students == null) {
            return new ResponseEntity<String> ("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @PostMapping("students")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        //@Request body returns object i.e it converts jason or xml file to object
        //it works just opposite of response body
        Student responseStudent = studentService.saveStudent(student);
        return new ResponseEntity<Student>(responseStudent, HttpStatus.CREATED);
    }

    @PutMapping("students")
    public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable Long id) {
        Student responseStudent = studentService.updateStudent(student, id);
        return new ResponseEntity<Student>(responseStudent, HttpStatus.OK);
    }


    @DeleteMapping("students")
    public ResponseEntity<?> deleteStudent(@RequestBody Student student, @PathVariable Long id) {
        Student responseStudent = studentService.deleteStudent(id);
        return new ResponseEntity<Student>(responseStudent, HttpStatus.OK);
    }



    @PostMapping("students/{firstName}/{lastName}/{email}")
    public ResponseEntity<?> saveStudentPath(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String email) {
        Student student = Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .emailId(email)
                .build();
        Student responseStudent = studentService.saveStudent(student);
        return new ResponseEntity<Student>(responseStudent, HttpStatus.CREATED);
    }

    @GetMapping("student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        //@PathVariable is a Spring annotation which indicates that a
        // method parameter should be bound to a URI template variable
        Optional<Student> student = studentService.getStudentById(id);
        if(!student.isPresent()) {
            System.out.println("here");
            return new ResponseEntity<String> ("Student does not exist.", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
        }
    }

}
