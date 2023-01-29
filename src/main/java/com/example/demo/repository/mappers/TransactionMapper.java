package com.example.demo.repository.mappers;

import com.example.demo.banque.Compte;
import com.example.demo.banque.Transaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionMapper implements RowMapper<Transaction> {
    public Transaction mapRow(ResultSet rss, int rowNum) throws SQLException {

        Transaction transaction=new Transaction();

        transaction.setId(rss.getInt("transaction_id"));
        transaction.setNouvellevaleur(rss.getInt("nouvellevaleur"));
        transaction.setAncienvaleur(rss.getInt("ancienvaleur"));
        transaction.setDate(rss.getString("date"));
        transaction.setCompte(new Compte());
        transaction.setCompteId(rss.getInt("compte_id"));
        return transaction;
    }}