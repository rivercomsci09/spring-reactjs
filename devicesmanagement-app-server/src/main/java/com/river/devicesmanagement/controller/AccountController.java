package com.river.devicesmanagement.controller;

import com.river.devicesmanagement.model.Account;
import com.river.devicesmanagement.security.CurrentUser;
import com.river.devicesmanagement.security.UserPrincipal;
import com.river.devicesmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Account>> findAllAccount() {
        List<Account> accounts = accountService.findAllAccount();
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Integer id) {
        Optional<Account> account = accountService.findById(id);
        if (!account.isPresent()) {
            return new ResponseEntity<>(account.get(),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(account.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        accountService.save(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/accounts/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") Integer id) {
        try {
            accountService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/user/me")
    @PreAuthorize("hasAnyAuthority('USER')")
    public Account getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        Account userSummary = new Account(currentUser.getId(), currentUser.getUsername());
        return userSummary;
    }
}
