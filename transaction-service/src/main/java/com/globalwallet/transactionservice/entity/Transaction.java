package com.globalwallet.transactionservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fromWalletId;
    private Long toWalletId;

    private Double amount;

    private String fromCurrency;
    private String toCurrency;

    private Double convertedAmount;
}