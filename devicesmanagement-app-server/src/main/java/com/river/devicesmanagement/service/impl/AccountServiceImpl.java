package com.river.devicesmanagement.service.impl;

import com.river.devicesmanagement.model.Account;
import com.river.devicesmanagement.model.Role;
import com.river.devicesmanagement.repository.AccountRepository;
import com.river.devicesmanagement.repository.RoleRepository;
import com.river.devicesmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
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

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;

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

    //    @Override
//    public void save(Account account) {
//        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
//        accountRepository.save(account);
//        Role userRole = roleRepository.findByRolename("USER");
//        account.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//        accountRepository.save(account);
//    }
    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteById(Integer id) {
        accountRepository.deleteById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
        return accountRepository.existsByUsername(username);
    }
}
