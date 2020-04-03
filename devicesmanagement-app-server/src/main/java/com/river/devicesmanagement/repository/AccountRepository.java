package com.river.devicesmanagement.repository;

import com.river.devicesmanagement.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByUsername(String username);

    @Query("SELECT a.id, a.username, a.email, r.rolename FROM Account a INNER JOIN a.roles r")
    List<Object[]> getAccount();

    boolean existsByUsername(String username);
}
