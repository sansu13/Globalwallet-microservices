package com.globalwallet.userservice.controller;

import com.globalwallet.userservice.entity.Wallet;
import com.globalwallet.userservice.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public Wallet createWallet(@RequestBody Wallet wallet) {
        return walletService.createWallet(wallet);
    }

    @GetMapping("/user/{userId}")
    public List<Wallet> getWallets(@PathVariable Long userId) {
        return walletService.getUserWallets(userId);
    }
    @PutMapping("/{walletId}/deduct")
    public Wallet deductBalance(@PathVariable Long walletId, @RequestParam Double amount) {
        return walletService.deductBalance(walletId, amount);
    }

    @PutMapping("/{walletId}/add")
    public Wallet addBalance(@PathVariable Long walletId, @RequestParam Double amount) {
        return walletService.addBalance(walletId, amount);
    }
}