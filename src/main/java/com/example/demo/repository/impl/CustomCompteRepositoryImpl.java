package com.example.demo.repository.impl;

import com.example.demo.banque.Compte;
import com.example.demo.repository.CustomCompteRepository;
import com.example.demo.repository.mappers.CompteMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CustomCompteRepositoryImpl implements CustomCompteRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public List<Compte> findAllComptes(){
//        MapSqlParameterSource parameters = new MapSqlParameterSource();
//        parameters.addValue("date", date);

        String sql="select * from compte";
        List<Compte> result=new ArrayList<>();

        try{
            result=jdbcTemplate.query(
                    sql,  new CompteMapper());

        }catch (EmptyResultDataAccessException e){
            log.error(e.getLocalizedMessage());
        }
        if (result.isEmpty()) {
            return new ArrayList<>();
        } else {
            return result;
        }

    }

    @Override
    public List<Compte> findCompteById(int id){
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);
log.info(""+id);
        String sql="select * from compte where compte_id=:id";


        List<Compte> result=new ArrayList<>();

        try{
            result=jdbcTemplate.query(
                    sql,
                    parameters,
                    new CompteMapper());

        }catch (EmptyResultDataAccessException e){
            log.error(e.getLocalizedMessage());
        }
        if (result.isEmpty()) {
            return new ArrayList<>();
        } else {
            return result;
        }

    }
    @Override
    public List<Compte> findCompteWithMoreThan(int qte){
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("qte", qte);
        String sql="select * from compte where compte > :qte";


        List<Compte> result=new ArrayList<>();

        try{
            result=jdbcTemplate.query(
                    sql,
                    parameters,
                    new CompteMapper());

        }catch (EmptyResultDataAccessException e){
            log.error(e.getLocalizedMessage());
        }
        if (result.isEmpty()) {
            return new ArrayList<>();
        } else {
            return result;
        }

    }
}
