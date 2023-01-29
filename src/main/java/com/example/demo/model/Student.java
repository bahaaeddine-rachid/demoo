package com.example.demo.model;


import com.example.demo.banque.Transaction;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="student_id")
    Integer id;
    String fullname;
    String datenaissance;
    String addresse;
    String email;



    public Student(Student student) {
        this.id = student.getId();
        this.fullname= student.getFullname();
        this.datenaissance=student.getDatenaissance();
        this.addresse= student.getAddresse();
        this.email=student.getEmail();

    }

}
