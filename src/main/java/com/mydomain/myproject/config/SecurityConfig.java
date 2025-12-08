package com.mydomain.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// 07.12.2025 - Added due to token showing as "httpOnly:true" which is stopping JavaScript from reading the cookie needed to allow access and for app to work as coded
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
//07.12.2025 - Trying because still getting error 403 
//import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;



@Configuration
@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
public class SecurityConfig{
    
    // SecurityFilterChain sets up the security rules

    // Spring managed object
    @Bean
    // SecurityFilterChain sets up the security rules
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*
        http
            .cors()
            .and()
            .csrf(csrf -> csrf
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            );
        */
        http
            .cors(cors -> {}) // enable CORS
            .csrf(csrf -> csrf
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            );


        // Token Problem Fix? Set to httpOnly: True but we want it to be false so JavaScript can read the cookies  
        http
            .csrf(csrf -> csrf
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            );
        
        http
            // starts setting access rules.
            //.authorizeHttpRequests()
            //.authorizeRequests()
            //"(auth -> auth ...) is a lambda expression" Codecademy AI - it sets up rules
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
                "/users",
                "/login",
                // Temp 
                "/groupCreation/index.html",
                // 06.12.2025 - Temp for testing as 403 error from security dependency
                //"*", Doesnt work - server wouldn't start - so commented out
                "/**"

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

    // 07.12.2025 - Trying because still getting error 403 on registeration submit button pressed  
/* commented out on 08.12.2025 after advice from codecademy AI as 403 error came back on submit of registration - commenting out fixed it    
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
*/
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedOriginPattern("*"); // or specify your frontend URL
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
