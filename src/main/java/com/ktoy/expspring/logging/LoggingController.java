package com.ktoy.expspring.logging;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/logging")
@AllArgsConstructor
public class LoggingController {

    private final LoggingService loggingService;

    @RequestMapping(value="/insert")
    public String insert(LoggingDTO loggingDTO){
        loggingService.insertLogging(loggingDTO);
        return "redirect:/Main.do";
    }
}
