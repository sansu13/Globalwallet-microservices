package com.globalwallet.transactionservice.repository;

import com.globalwallet.transactionservice.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, String> {
}