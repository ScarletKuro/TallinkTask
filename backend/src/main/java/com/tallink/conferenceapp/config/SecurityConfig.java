package com.tallink.conferenceapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/console/**");
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers()
                .antMatchers("/oauth/authorize")
                .regexMatchers("/(?!oauth)")
                .antMatchers("/*")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/authorize").hasRole("ADMIN")
                .anyRequest().denyAll()
                //.and()
                //.formLogin()
                //.loginPage("/login")
                //.permitAll()
                .and()
                .httpBasic().disable()
                .csrf()
                .csrfTokenRepository(new CookieCsrfTokenRepository());
    }
}