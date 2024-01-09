package com.testdev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers("/main/protected").hasAnyRole("userrole", "adminrole")
                .requestMatchers("/main/hello").hasRole("admin")
                .requestMatchers("/main/user").hasRole("user")
                .requestMatchers("/main/public").permitAll()
                .anyRequest()
                .authenticated()
        )
                .httpBasic();
        return http.build();
    }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http.authorizeRequests().requestMatchers("/**").hasRole("USER").and().httpBasic();
    //     return http.build();
    // }

    @Bean
    public InMemoryUserDetailsManager userDetailService(){
        UserDetails user = User.builder()
            .username("user")
            .password("user")
            .roles("userrole")
            .build();
        UserDetails admin = User.builder()
            .username("admin")
            .password("admin")
            .roles("adminrole")
            .build();
        return new InMemoryUserDetailsManager(user , admin);
    }

    @Bean
    public PasswordEncoder passwordEncod(){
        return new BCryptPasswordEncoder();
    }
}
