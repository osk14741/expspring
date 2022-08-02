package com.ktoy.expspring.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @RequestMapping(value="/list")
    public ModelAndView memberList(){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("member_list");
        mav.addObject("memberList", memberService.findAll());

        log.info(memberService.findAll().toString());

        return mav;
    }
}
