package com.ktoy.expspring.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.ktoy.expspring.common.StaticUtil.llc;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @RequestMapping(value = "/register")
    public ModelAndView memberRegister() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/member/register.html");

        return mav;
    }

    @RequestMapping(value = "/list")
    public ModelAndView memberList() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("member_list");
        mav.addObject("memberList", memberService.findAll());

        log.info(memberService.findAll().toString());

        return mav;
    }

    @PostMapping(value = "/Sign_in.do")
    public ModelAndView signIn(MemberDTO memberDTO) {
        ModelAndView mav = new ModelAndView();

        boolean flag = memberService.insertUser(memberDTO);
        if(flag) mav.setViewName("redirect:security/login?error");
        else mav.setViewName("redirect:security/login");

        return mav;
    }
}
