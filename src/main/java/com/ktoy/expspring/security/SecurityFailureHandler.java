package com.ktoy.expspring.security;

import com.ktoy.expspring.logging.LoggingDTO;
import com.ktoy.expspring.logging.LoggingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.ktoy.expspring.common.StaticUtil.llc;

@Component
@AllArgsConstructor
@Slf4j
public class SecurityFailureHandler implements AuthenticationFailureHandler {

    private final LoggingService loggingService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        llc.add("SIGN IN FAILED");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        loggingService.insertLogging(new LoggingDTO("1", exception.getMessage()));

        if(exception instanceof BadCredentialsException){
            response.sendRedirect("/security/login?error="+SecurityErrorCode.BAD_CREDENTIALS.getValue());
        } else {
            response.sendRedirect("/security/login");
        }
    }
}
