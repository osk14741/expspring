package com.ktoy.expspring.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class SocketController {

    @RequestMapping(value="/socket/chat")
    public String socketChat(Model model){


        return "socket/chat.html";
    }

}
