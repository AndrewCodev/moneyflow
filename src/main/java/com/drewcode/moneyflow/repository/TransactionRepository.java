package com.drewcode.moneyflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drewcode.moneyflow.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
