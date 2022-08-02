package com.ktoy.expspring.member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("SELECT * FROM security_member")
    List<MemberDTO> findAll();
}
