package com.ktoy.expspring.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping(value = "/Main.do")
    private String mainIndex(){
        System.out.println("yo....");
        return "main/index";
    }
}
