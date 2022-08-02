package com.ktoy.expspring.security;

import com.ktoy.expspring.filter.ApiFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/security/login").permitAll()
//                .antMatchers("/h2-console").permitAll()
                .anyRequest()
                .permitAll()
//                .authenticated()
            .and()
//                .addFilterAfter(, BasicAuthenticationFilter.class)
                .formLogin()
                .loginPage("/security/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureUrl("/security/login")
                .defaultSuccessUrl("/Main.do");




        return http.build();
    }


}
