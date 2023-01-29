package com.example.demo.repository.impl;

import com.example.demo.banque.*;
import com.example.demo.banque.QTransaction;
import com.example.demo.repository.CustomTransactionRepository;
import com.example.demo.repository.mappers.CompteMapper;
import com.example.demo.repository.mappers.TransactionMapper;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class CustomTransactionRepositoryImpl implements CustomTransactionRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Transaction> findAllTransactions(){

        String sql="select * from transaction";
        String sql2="select * from compte where compte_id=:compteId";

        List<Transaction> result=new ArrayList<>();

        try{
            result=jdbcTemplate.query(
                    sql,
                    new TransactionMapper());

        }catch (EmptyResultDataAccessException e){

        }
        if (result.isEmpty()) {
            return new ArrayList<>();
        } else {
            for(Transaction tr:result){
                MapSqlParameterSource parameters = new MapSqlParameterSource();
                parameters.addValue("compteId", tr.getCompteId());


                tr.setCompte(
                        jdbcTemplate.query(sql2,parameters,new CompteMapper()).get(0)
                );
            }

            return result;
        }

    }

    @Override
    public List<Transaction> findAllTransactions2(){

        QTransaction qTransaction=QTransaction.transaction;

        return new JPAQuery<Transaction>(em)
                .select(qTransaction)
                .from(qTransaction)
                .fetch();
    }
}
