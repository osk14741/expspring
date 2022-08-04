package com.ktoy.expspring.security;


import com.ktoy.expspring.member.MemberDAO;
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

    // UserDetailsService를 implemets 받아서 loadUserByUsername을 작성해야 로직을 탐.

    private final MemberDAO memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        MemberDTO memberDTO;
        memberDTO = memberService.loadMemByUsername(username);

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(memberDTO == null) throw new UsernameNotFoundException("CAN'T FIND USERNAME");

        if(memberDTO.getUserRole() == 0){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else if(memberDTO.getUserRole() == 1){
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        } else if(memberDTO.getUserRole() == 2){
            authorities.add(new SimpleGrantedAuthority(Role.TEST.getValue()));
        } else {
            log.info(memberDTO.getUserRole() + "? role 다른듯?");
        }

        // User를 UserDetails를 implements해서 바꿨을 때 duplication session 체크에서
        // .equals()가 작동을 하지 않으므로 .equals()를 재정의 해 줄 필요성이 있음.
        return new User(memberDTO.getUsername(), memberDTO.getPassword(), authorities);
    }
}
