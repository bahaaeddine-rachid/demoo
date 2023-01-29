package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value="/findAllStudents", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> result=studentService.findAllStudents();
        return ResponseEntity.ok(result);
    }
}
