package com.river.devicesmanagement.configure;

import com.river.devicesmanagement.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfigure extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/login", "/register").permitAll()
                .antMatchers(HttpMethod.POST,"/api/accounts").permitAll()
                .antMatchers("/api/**").access("hasAnyAuthority('USER', 'ADMIN')")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("http://localhost:5000",true)
//                .failureUrl("http://localhost:5000?error=true")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("http://localhost:5000");
//                http.exceptionHandling()
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
    }
}
