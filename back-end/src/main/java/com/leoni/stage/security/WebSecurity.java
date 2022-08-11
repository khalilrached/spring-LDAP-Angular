package com.leoni.stage.security;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@RestController
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .and().formLogin()
        ;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .ldapAuthentication()
        .userDnPatterns("uid={0},ou=people")
        .groupSearchBase("ou=groups")
        .contextSource()
        .url("ldap://localhost:8389/dc=springframework,dc=org")
        .and()
        .passwordCompare()
        .passwordEncoder(new BCryptPasswordEncoder())
        .passwordAttribute("userPassword");
    }

    @RequestMapping
    public Authentication getAuth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }


}