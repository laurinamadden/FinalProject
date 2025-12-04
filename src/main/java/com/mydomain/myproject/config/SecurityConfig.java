package com.mydomain.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
public class SecurityConfig{
    
    // SecurityFilterChain sets up the security rules

    // Spring managed object
    @Bean
    // SecurityFilterChain sets up the security rules
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        // starts setting access rules.
        //.authorizeHttpRequests()
        //.authorizeRequests()
        //"(auth -> auth ...) is a lambda expression" Codecademy AI - its ets up rules
        .authorizeHttpRequests(auth -> auth
        // allows access without logged in
        //.antMatchers("/register/index.html", "/login/index.html", "/script/script.js", "/style/style.css").permitAll()
        .requestMatchers(
            "/",
            "/index.html", 
            "/register/index.html", 
            "/login/index.html", 
            "/script/script.js", 
            "/style/style.css",
            // Temp
            "/groupCreation/index.html"
        ).permitAll()
        // tells that log in is needed for other paths
        .anyRequest().authenticated()
        // links two diff types of security settings by ending one and starting another 
        //.and()
        // enables built in log in form - shouldnt need it
        //.formLogin();
        );
        // return finishs task 
        // and returns security set up
        return http.build();
    }


}
