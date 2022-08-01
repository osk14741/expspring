package com.ktoy.expspring.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/filter/*")
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

        log.info("========BEFORE DOFILTER(ApiFilter.java) REQUEST URI : " + requestURI + " ========");
        chain.doFilter(request, response);
        log.info("========AFTER DOFILTER(ApiFilter.java) REQUEST URI : " + requestURI + " ========");
    }

    @Override
    public void destroy() {
        log.info("========DESTROY FILTER(ApiFilter.java)========");
        Filter.super.destroy();
    }
}
