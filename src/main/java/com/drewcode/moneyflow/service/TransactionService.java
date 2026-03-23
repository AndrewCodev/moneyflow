package com.drewcode.moneyflow.service;

import java.util.List;

import com.drewcode.moneyflow.entity.Transaction;

public interface TransactionService {
    Transaction save(Transaction transaction);

    List<Transaction> findAll();

    Transaction update(Transaction transaction);

    Transaction findById(Long id);

    void deleteById(Long id);
}
