package com.ktoy.expspring.member;

import com.ktoy.expspring.common.StaticUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ktoy.expspring.common.StaticUtil.lls;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService{

    private final MemberDAO memberDao;
    private final PasswordEncoder passwordEncoder;

    public List<MemberDTO> findAll(){
        return memberDao.findAll();
    }

    public MemberDTO loadUserByUsername(String username){
        return memberDao.loadMemByUsername(username);
    }

    public boolean insertUser(MemberDTO memberDTO) {
        try{
            memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
            return memberDao.insertUser(memberDTO);
        } catch(Exception e){
            return false;
        }

    }

}
