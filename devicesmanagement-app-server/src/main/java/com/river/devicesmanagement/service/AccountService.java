package com.river.devicesmanagement.service;

import com.river.devicesmanagement.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Optional<Account> findByUsername(String username);

    List<Account> findAllAccount();

    List<Object[]> getAccount();

    Optional<Account> findById(int id);

    Account save(Account account);

    void deleteById(Integer id);

    boolean existsByUsername(String username);
}
