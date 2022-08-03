package com.ktoy.expspring.main;

import com.ktoy.expspring.aop.AOPInterface;
import com.ktoy.expspring.logging.LoggingDTO;
import com.ktoy.expspring.logging.LoggingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class MainController {

    private final LoggingService loggingService;

    @GetMapping(value ="/")
    @AOPInterface
    public String moveToIndex(){
        log.info("moveToIndex");
        return "redirect:/Main.do";
    }

    @GetMapping(value = "/Main.do")
    @AOPInterface
    public ModelAndView mainIndex(){
        List<LoggingDTO> list = loggingService.selectAll();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("main/index.html");
        mav.addObject("LoggingList", list);

        return mav;
    }


}
