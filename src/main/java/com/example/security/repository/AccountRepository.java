package com.example.security.repository;

import com.example.security.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository {

    List<Account> accounts = List.of(
            new Account(1, "Dharani", 20000L),
            new Account(2, "Prasad", 20000L),
            new Account(3, "Prasanth", 20000L)
    );

    public Account getAccountByID(Integer id) {
        return accounts.stream()
                .filter(account -> id.equals(account.id()))
                .findFirst().orElse(null);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
