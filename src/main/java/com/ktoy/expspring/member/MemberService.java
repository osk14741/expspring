package com.ktoy.expspring.member;

import com.ktoy.expspring.common.StaticUtil;
import com.ktoy.expspring.logging.LoggingCode;
import com.ktoy.expspring.logging.LoggingDAO;
import com.ktoy.expspring.logging.LoggingDTO;
import com.ktoy.expspring.logging.LoggingService;
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
    private final LoggingDAO loggingDAO;


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

    public MemberDTO selectOneByMemberIdx(MemberDTO memberDTO) {
        return memberDao.selectOneByMemberIdx(memberDTO);
    }

    public boolean updateMember(MemberDTO memberDTO) {
        loggingDAO.insertLogging(new LoggingDTO(LoggingCode.MEMBER_UPDATE.getErrorCode(), LoggingCode.MEMBER_UPDATE.getErrorText()));
        return memberDao.updateMember(memberDTO);
    }
}
