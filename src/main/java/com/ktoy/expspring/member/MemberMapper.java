package com.ktoy.expspring.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("SELECT * FROM security_member")
    List<MemberDTO> findAll();

    @Select("SELECT * FROM security_member where username=#{username}")
    MemberDTO loadMemByUsername(String username);

    @Insert("Insert into security_member " +
            "(username, password, realName, phoneNumber, email, age, userRole)" +
            "values " +
            "(#{username}, #{password}, #{realName}, #{phoneNumber}, #{email}, #{age}, #{userRole})")
    boolean insertUser(MemberDTO memberDTO);
}
