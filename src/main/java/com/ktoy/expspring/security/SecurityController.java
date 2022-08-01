package com.ktoy.expspring.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/security")
public class SecurityController {

    @RequestMapping(value="/login")
    public String login(){

        return "/login";
    }
}
