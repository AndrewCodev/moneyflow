package com.drewcode.moneyflow.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private LocalDateTime date;
    private String description;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public Transaction() {
    }

    public Transaction(BigDecimal amount, LocalDateTime date, String description, TransactionType type) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionType getType() {
        return this.type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

}
