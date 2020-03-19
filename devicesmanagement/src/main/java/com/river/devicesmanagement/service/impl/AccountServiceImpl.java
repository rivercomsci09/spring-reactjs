package com.river.devicesmanagement.service.impl;

import com.river.devicesmanagement.model.Account;
import com.river.devicesmanagement.repository.AccountRepository;
import com.river.devicesmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    /*    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }*/

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAllAccount() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<Object[]> getAccount() {
        return accountRepository.getAccount();
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }
}
