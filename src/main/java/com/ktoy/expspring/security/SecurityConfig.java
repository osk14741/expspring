package com.ktoy.expspring.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {

    private final SecuritySuccessHandler securitySuccessHandler;
    private final SecurityFailureHandler securityFailureHandler;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
        return (web) -> web.ignoring().antMatchers("/static/**", "/layout/basic");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/security/login").permitAll()
            .antMatchers("/security/logout").permitAll()
            .antMatchers("/security/only_admin").hasRole("ADMIN")
            .antMatchers("/security/only_member").hasRole("MEMBER")
            .anyRequest().authenticated();

        http
            .exceptionHandling()
            .accessDeniedHandler(customAccessDeniedHandler);

        http
            .formLogin()
            .loginPage("/security/login")
            .loginProcessingUrl("/security/login_proc")
            .defaultSuccessUrl("/Main.do")
            .successHandler(securitySuccessHandler)
            .failureHandler(securityFailureHandler)
            .permitAll();

        http
            .logout()
            .logoutUrl("/security/logout")
            .logoutSuccessUrl("/security/login")
            .invalidateHttpSession(true);

        return http.build();
    }




}
