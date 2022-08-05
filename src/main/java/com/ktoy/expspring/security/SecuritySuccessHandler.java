package com.ktoy.expspring.security;


import com.ktoy.expspring.logging.LoggingDTO;
import com.ktoy.expspring.logging.LoggingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.ktoy.expspring.common.StaticUtil.llc;

@Slf4j
@Component
@AllArgsConstructor
public class SecuritySuccessHandler implements AuthenticationSuccessHandler {

    private final LoggingService loggingService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // String username = authentication.getName();

        llc.add("SIGN IN SUCCESS");
        String username = authentication.getName();
        String password = request.getParameter("password");

        request.getSession().setAttribute("username", username);

        loggingService.insertLogging(new LoggingDTO("0", "Username : " + username + ", Password : " + password));

        response.sendRedirect("/Main.do");
    }

}
