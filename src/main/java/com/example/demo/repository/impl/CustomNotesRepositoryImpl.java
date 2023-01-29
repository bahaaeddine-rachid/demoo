package com.example.demo.repository.impl;

import com.example.demo.banque.QTransaction;
import com.example.demo.banque.Transaction;
import com.example.demo.model.Notes;
import com.example.demo.model.QNotes;
import com.example.demo.repository.CustomNotesRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class CustomNotesRepositoryImpl implements CustomNotesRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Notes> findAllNotes(){

        return new ArrayList<>();
    }
}
