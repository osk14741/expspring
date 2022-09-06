package com.ktoy.expspring.filter;

import com.ktoy.expspring.member.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class ApiFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        log.info("========INIT FILTER(ApiFilter.java)========");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String requestURI = req.getRequestURI();

        // 아이디 비교 하고
        // token auth token

//        log.info("========BEFORE DOFILTER(ApiFilter.java)========");
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        for (Cookie cookie : cookies) {
            ResponseCookie responseCookie = ResponseCookie.from(cookie.getName(), cookie.getValue())
                    .httpOnly(true)
                    .secure(true)
                    .maxAge(Duration.ofHours(1))
                    .sameSite("None")
                    .build();
            ((HttpServletResponse) response).setHeader(HttpHeaders.SET_COOKIE, responseCookie.toString());
        }
        chain.doFilter(request, response);
//        log.info("========AFTER DOFILTER(ApiFilter.java)========");
    }

    @Override
    public void destroy() {
        log.info("========DESTROY FILTER(ApiFilter.java)========");
        Filter.super.destroy();
    }
}
