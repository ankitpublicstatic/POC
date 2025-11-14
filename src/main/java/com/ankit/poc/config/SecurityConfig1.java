package com.ankit.poc.config;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
public class SecurityConfig1 {

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.csrf(csrf -> csrf.disable()) // disable CSRF for APIs

        .authorizeHttpRequests(auth -> auth.requestMatchers("/public/**").permitAll() // public URLs
            .anyRequest().authenticated()// secure others URLs

        ).httpBasic(withDefaults()); // use basic authentication
    return http.build();
  }
}
