package com.leoni.stage.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/login*","/form/**","/","/css/**","/img/**","/about","/js/**","/home").permitAll()
            .anyRequest()
            .authenticated()
        .and()
            .formLogin()
            .loginPage("/loginpage")
            .loginProcessingUrl("/applogin")
            .defaultSuccessUrl("/user?link")
            .failureUrl("/loginpage.html?error=true")
        .and()
            .logout()
            .logoutUrl("/user/logout")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
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
            .passwordAttribute("userPassword")
        ;
    }

}