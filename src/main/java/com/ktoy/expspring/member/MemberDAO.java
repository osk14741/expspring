package com.ktoy.expspring.member;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;

    public List<MemberDTO> findAll(){

        return memberMapper.findAll();
    }

    public MemberDTO loadMemByUsername(String username){
        return memberMapper.loadMemByUsername(username);
    }

    public boolean insertUser(MemberDTO memberDTO) {
        return memberMapper.insertUser(memberDTO);
    }


}
