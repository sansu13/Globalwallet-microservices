package com.globalwallet.transactionservice.service;

import com.globalwallet.transactionservice.entity.Transaction;
import com.globalwallet.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.globalwallet.transactionservice.entity.ExchangeRate;
import com.globalwallet.transactionservice.repository.ExchangeRateRepository;

@Service
public class TransactionService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private RestTemplate restTemplate = new RestTemplate();

    public Transaction transfer(Transaction transaction) {

        ExchangeRate fromRate = exchangeRateRepository
                .findById(transaction.getFromCurrency())
                .orElseThrow(() -> new RuntimeException("From currency not found"));

        ExchangeRate toRate = exchangeRateRepository
                .findById(transaction.getToCurrency())
                .orElseThrow(() -> new RuntimeException("To currency not found"));

// Convert via base currency (USD)
        double usdAmount = transaction.getAmount() / fromRate.getRate();
        double convertedAmount = usdAmount * toRate.getRate();
        transaction.setConvertedAmount(convertedAmount);

        // STEP 1: Deduct from sender wallet
        String deductUrl = "http://localhost:8081/wallets/"
                + transaction.getFromWalletId()
                + "/deduct?amount=" + transaction.getAmount();

        restTemplate.put(deductUrl, null);

        // STEP 2: Add to receiver wallet
        String addUrl = "http://localhost:8081/wallets/"
                + transaction.getToWalletId()
                + "/add?amount=" + convertedAmount;

        restTemplate.put(addUrl, null);

        // STEP 3: Save transaction
        return transactionRepository.save(transaction);
    }
}