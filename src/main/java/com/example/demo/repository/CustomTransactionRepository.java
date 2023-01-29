package com.example.demo.repository;

import com.example.demo.banque.Transaction;

import java.util.List;

public interface CustomTransactionRepository {
    List<Transaction> findAllTransactions();

    List<Transaction> findAllTransactions2();
}
