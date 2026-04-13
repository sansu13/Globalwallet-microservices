package com.globalwallet.transactionservice.controller;

import com.globalwallet.transactionservice.entity.Transaction;
import com.globalwallet.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction transfer(@RequestBody Transaction transaction) {
        return transactionService.transfer(transaction);
    }
}