package com.drewcode.moneyflow.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.drewcode.moneyflow.entity.Transaction;
import com.drewcode.moneyflow.service.TransactionService;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    private TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("create")
    public Transaction create(@RequestBody Transaction transaction) {
        return service.save(transaction);
    }

    @GetMapping
    public List<Transaction> getAll() {
        return service.findAll();
    }

}
