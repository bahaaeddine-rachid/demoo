package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="student_module")
public class StudentModule {

    @EmbeddedId
    StudentModuleId id;


    @MapsId("studentId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id")
    Student student;

    @MapsId("moduleId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="module_id")
    Module module;

    private boolean reussi;

}
