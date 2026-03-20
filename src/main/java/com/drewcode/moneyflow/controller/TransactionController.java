package com.drewcode.moneyflow.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drewcode.moneyflow.entity.Transaction;
import com.drewcode.moneyflow.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        return service.save(transaction);
    }

    @GetMapping
    public List<Transaction> getAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public Transaction update(@PathVariable Long id, @RequestBody Transaction transaction) {
        // Trae la transacción existente

        Transaction existing = service.findById(id);

        // Actualiza solo los campos que quieras
        existing.setAmount(transaction.getAmount());
        existing.setDate(transaction.getDate());
        existing.setDescription(transaction.getDescription());
        existing.setType(transaction.getType());

        // Guarda
        return service.save(existing);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 cuando se borra correctamente
    }
}
