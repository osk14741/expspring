package com.ktoy.expspring.member;

import com.ktoy.expspring.logging.LoggingDAO;
import com.ktoy.expspring.logging.LoggingDTO;
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

    public MemberDTO loadUserByUsername(String username){
        return memberDao.loadMemByUsername(username);
    }


}
