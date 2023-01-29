package com.example.demo.repository.mappers;

import com.example.demo.banque.Compte;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompteMapper implements RowMapper<Compte> {

    @Override
    public Compte mapRow(ResultSet rs, int rowNum) throws SQLException {

        Compte compte=new Compte();

        compte.setId(rs.getInt("compte_id"));
        compte.setCompte(rs.getInt("compte"));
        compte.setUtilisateur(rs.getString("utilisateur"));
        compte.setCity(rs.getString("city"));
        return compte;
    }
}
