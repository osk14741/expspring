package com.ktoy.expspring.board;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("board_list", boardService.selectAll());

        return "board/board_list.html";
    }


}
