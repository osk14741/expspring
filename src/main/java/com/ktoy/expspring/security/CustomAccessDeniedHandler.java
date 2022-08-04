package com.ktoy.expspring.security;

import com.ktoy.expspring.logging.LoggingCode;
import com.ktoy.expspring.logging.LoggingDTO;
import com.ktoy.expspring.logging.LoggingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@AllArgsConstructor
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final LoggingService loggingService;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.info("|| ACCESS DENIED");
        loggingService.insertLogging(new LoggingDTO(LoggingCode.ACCESS_DENIED.getErrorCode(), LoggingCode.ACCESS_DENIED.getErrorText()));
        response.sendRedirect("/Main.do?access_denied");
    }
}
