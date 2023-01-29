package com.example.demo.repository.mappers;

import com.example.demo.model.Student;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        Student student=new Student();

        student.setId(rs.getInt("student_id"));
        student.setFullname(rs.getString("fullname"));
        student.setDatenaissance(rs.getString("datenaissance"));
        student.setAddresse(rs.getString("addresse"));
        student.setEmail(rs.getString("email"));

        return student;
    }
}
