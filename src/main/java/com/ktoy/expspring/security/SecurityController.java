package com.ktoy.expspring.security;

import com.ktoy.expspring.member.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/security")
@Slf4j
public class SecurityController {

    @RequestMapping(value="/login")
    public String login(MemberDTO memberDTO){
        log.info("HELLO LOGIN");
        return "/login.html";
    }

//    @PostMapping(value="/login_action")
//    public String login_action(MemberDTO memberDTO){
//        log.info("HELLO LOGIN_ACTION");
//        return "redirect:/Main.do";
//    }
}
