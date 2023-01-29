package com.example.demo.repository;

import com.example.demo.model.Student;

import java.util.List;

public interface CustomStudentRepository {
    List<Student> findAllStudents2();

    List<Student> findAllStudents();
}
