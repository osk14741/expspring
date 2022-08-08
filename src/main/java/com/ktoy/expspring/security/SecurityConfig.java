package com.ktoy.expspring.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {

    private final SecuritySuccessHandler securitySuccessHandler;
    private final SecurityFailureHandler securityFailureHandler;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    private final CustomLogoutSuccessHandler customLogoutSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
        return (web) -> web.ignoring().antMatchers("/static/**", "/layout/basic");
    }

    // TODO : Customize Spring Security AuthenticationProvider => https://shxrecord.tistory.com/239
    // TODO : Customize Spring Security CustomDetails

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/member/register", "/member/Sign_in.do").permitAll()
            .antMatchers("/security/login").permitAll()
            .antMatchers("/security/logout").permitAll()
            .antMatchers("/security/only_admin").hasAnyRole(new String[]{"ADMIN", "TEST"})
            .antMatchers("/security/only_member").hasAnyRole(new String[]{"MEMBER", "TEST"})
            .anyRequest().authenticated();

        http
            .exceptionHandling()
            .accessDeniedHandler(customAccessDeniedHandler);

        http
            .formLogin()
            .loginPage("/security/login")
            .loginProcessingUrl("/security/login_proc") // URL in form(action), method = post
            .defaultSuccessUrl("/Main.do")
            .successHandler(securitySuccessHandler)
            .failureHandler(securityFailureHandler)
            .permitAll();

        http
            .logout()
            .logoutUrl("/security/logout")
            .logoutSuccessHandler(customLogoutSuccessHandler)
            .invalidateHttpSession(true); // Session 제거 여부

        http // If customize UserDetails, also need to customize .equals()
            .sessionManagement()
            .maximumSessions(1) // 동시 접속 가능한 세션 수, -1 -> 무제한
            .maxSessionsPreventsLogin(false) // false -> 이전 접속자 만료, true -> 새 접속자 막기
            .expiredUrl("/security/login?dup") // Session이 만료됐을 때 이동할 URL
            ;

        return http.build();
    }
}
