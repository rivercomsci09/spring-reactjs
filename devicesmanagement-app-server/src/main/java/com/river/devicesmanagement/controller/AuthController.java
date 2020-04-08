package com.river.devicesmanagement.controller;

import com.river.devicesmanagement.exception.AppException;
import com.river.devicesmanagement.model.Account;
import com.river.devicesmanagement.model.Role;
import com.river.devicesmanagement.payload.ApiResponse;
import com.river.devicesmanagement.payload.JwtAuthenticationResponse;
import com.river.devicesmanagement.payload.LoginRequest;
import com.river.devicesmanagement.payload.SignUpRequest;
import com.river.devicesmanagement.security.JwtTokenProvider;
import com.river.devicesmanagement.service.AccountService;
import com.river.devicesmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(accountService.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Account account = new Account(signUpRequest.getEmail(),signUpRequest.getUsername(), signUpRequest.getPassword());

        account.setPassword(passwordEncoder.encode(account.getPassword()));

        Role userRole = roleService.findByName("USER")
                .orElseThrow(() -> new AppException("User Role not set."));

        account.setRoles(Collections.singleton(userRole));

        Account result = accountService.save(account);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/accounts/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

}
