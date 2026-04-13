package com.globalwallet.transactionservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "exchange_rates")
@Data
public class ExchangeRate {

    @Id
    private String currency;

    private Double rate;
}