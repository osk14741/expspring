package com.ktoy.expspring.security;

import com.ktoy.expspring.logging.LoggingCode;
import com.ktoy.expspring.logging.LoggingDTO;
import com.ktoy.expspring.logging.LoggingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@AllArgsConstructor
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    private final LoggingService loggingService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // String username = authentication.getName();
        String username = authentication.getName();
        
//        session 제거
//        request.getSession().invalidate();

        log.info("username = " + username);
        loggingService.insertLogging(new LoggingDTO(LoggingCode.LOGOUT.getErrorCode(), LoggingCode.LOGOUT.getErrorText()));
        response.sendRedirect("/security/login?logout");
    }
}
