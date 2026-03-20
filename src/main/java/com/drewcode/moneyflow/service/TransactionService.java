package com.drewcode.moneyflow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.drewcode.moneyflow.entity.Transaction;
import com.drewcode.moneyflow.exception.TransactionNotFoundException;
import com.drewcode.moneyflow.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> findAll() {
        return repository.findAll();
    }

    public Transaction update(Transaction transaction) {
        return repository.getReferenceById(transaction.getId());
    }

    public Transaction findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));
    }

    public void deleteById(Long id) {
        boolean exists = repository.existsById(id);

        if (!exists) {
            throw new TransactionNotFoundException(id); // tu excepción personalizada
        }
        repository.deleteById(id);
    }

}
