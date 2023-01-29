package com.example.demo.repository.impl;

import com.example.demo.model.QStudent;
import com.example.demo.model.Student;
import com.example.demo.repository.CustomStudentRepository;
import com.example.demo.repository.mappers.StudentMapper;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CustomStudentRepositoryImpl implements CustomStudentRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager emm;
    @Override
    public List<Student> findAllStudents() {
//        MapSqlParameterSource parameters = new MapSqlParameterSource();
//        parameters.addValue("date", date);

        String sql = "select * from student";


        List<Student> result = new ArrayList<>();

        try {
            result = jdbcTemplate.query(
                    sql, new StudentMapper());

        } catch (EmptyResultDataAccessException e) {
            log.error(e.getLocalizedMessage());
        }
        if (result.isEmpty()) {
            return new ArrayList<>();
        } else {
            return result;
        }
    }
    @Override
    public List<Student> findAllStudents2(){
        QStudent qStudent=QStudent.student;
        return new JPAQuery<Student>(emm)
                .select(Projections.constructor(Student.class,qStudent))
                .from(qStudent)
                .where(qStudent.id.between(10,20))
                .fetch();

    }
}
