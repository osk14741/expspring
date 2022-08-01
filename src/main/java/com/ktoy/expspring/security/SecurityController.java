package com.ktoy.expspring.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/security")
@Slf4j
public class SecurityController {

    @RequestMapping(value="/login")
    public String login(){

        return "/login";
    }
}
