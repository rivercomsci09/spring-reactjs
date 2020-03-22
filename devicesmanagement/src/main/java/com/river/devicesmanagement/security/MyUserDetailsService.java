package com.river.devicesmanagement.security;

import com.river.devicesmanagement.model.Account;
import com.river.devicesmanagement.model.Role;
import com.river.devicesmanagement.repository.RoleRepository;
import com.river.devicesmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    AccountService accountService;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountService.findByUsername(username);
        if (account.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        Set<Role> roles = account.get().getRoles();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRolename()));
            System.out.println(grantedAuthorities);
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(account.get().getUsername(), account.get().getPassword(),
                true, true, true, true, grantedAuthorities);
        return userDetails;
    }
}
