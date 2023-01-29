package com.example.demo.model;


import com.example.demo.banque.Compte;
import com.example.demo.banque.Transaction;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
@Table(name="notes")
public class Notes {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="note_id")
    Integer id;

    float note;

    String cours;

    @Column(name = "student_id")
    Integer studentId;


    @MapsId("studentId")
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student = new Student();

    public Notes(Notes notes) {
        this.id = notes.getId();
        this.note=notes.getNote();
        this.cours=notes.getCours();
        this.studentId=notes.getStudentId();
        this.student=notes.getStudent();
    }

}
