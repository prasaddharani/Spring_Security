package com.example.security.controller;

import com.example.security.model.Account;
import com.example.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    private ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAccounts();
        return ResponseEntity.ok().body(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findAccountByID(@PathVariable String id) {
        Account account = accountService.getAccountByID(Integer.valueOf(id));
        return ResponseEntity.ok().body(account);
    }
}
