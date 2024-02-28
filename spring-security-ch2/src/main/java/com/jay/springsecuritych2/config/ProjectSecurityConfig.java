package com.jay.springsecuritych2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /**
         * Below is the custom security configurations
         **/

        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount", "/myBalance", "/myCards", "/myLoans").authenticated()
                        .requestMatchers("/notices", "/contact").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();

        /**
         * Configuration to deny all the requests
         */

//        http.authorizeHttpRequests((requests) -> requests
//                .anyRequest().denyAll());
//
//        return http.build();

        /**
         * Configuration to permit all the requests
         */

//        http.authorizeHttpRequests((requests) -> requests
//                .anyRequest().permitAll());
//
//        return http.build();
    }
}
