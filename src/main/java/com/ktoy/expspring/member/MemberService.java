package com.ktoy.expspring.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDAO memberDao;

    public List<MemberDTO> findAll(){
        return memberDao.findAll();
    }


}
