package com.example.demo.repository.impl;

import com.example.demo.model.Module;
import com.example.demo.model.QModule;
import com.example.demo.repository.CustomModuleRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomModuleRepositoryImpl implements CustomModuleRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Module> findAllModules(){
        QModule qModule=QModule.module;
        return new JPAQuery<Module>(em)
                .select(qModule)
                .from(qModule)
                .fetch();
    }
}
