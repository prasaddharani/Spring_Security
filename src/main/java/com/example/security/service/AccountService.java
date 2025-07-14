package com.example.security.service;

import com.example.security.model.Account;
import com.example.security.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountByID(Integer id) {
        return accountRepository.getAccountByID(id);
    }

    public List<Account> getAccounts() {
        return accountRepository.getAccounts();
    }
}
