package com.ankit.poc.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests().antMatchers("/api/public/**").permitAll()
        .antMatchers("/api/admin/**").hasRole("ADMIN").anyRequest().authenticated().and()
        .oauth2ResourceServer().jwt();
  }
}
