package com.ktoy.expspring.main;

import com.ktoy.expspring.aop.AOPInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class MainController {

    @GetMapping(value ="/")
    @AOPInterface
    public String moveToIndex(){
        log.info("moveToIndex");
        return "redirect:/Main.do";
    }

    @GetMapping(value = "/Main.do")
    @AOPInterface
    public String mainIndex(){
        log.info("mainIndex");
        return "main/index.html";
    }


}
