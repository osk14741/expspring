package com.ktoy.expspring.security;


import com.ktoy.expspring.member.MemberDTO;
import com.ktoy.expspring.member.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        MemberDTO memberDTO;
        memberDTO = memberService.loadUserByUsername(username);

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(memberDTO == null) throw new UsernameNotFoundException("CAN'T FIND USERNAME");

        if(memberDTO.getUserRole() == 0){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else if(memberDTO.getUserRole() == 1){
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        } else {
            log.info(memberDTO.getUserRole() + "? role 다른듯?");
        }


        List<MemberDTO> memList = memberService.findAll();
        log.info(memList.toString());

        return new User(memberDTO.getUsername(), memberDTO.getPassword(), authorities);
    }
}
