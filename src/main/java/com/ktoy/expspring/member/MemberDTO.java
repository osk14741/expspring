package com.ktoy.expspring.member;

import lombok.Data;

@Data
public class MemberDTO {

    private int memberIdx;
    private String username;
    private String password;
    private String realName;
    private String phoneNumber;
    private String email;
    private int age;
    private int userRole; // 0 -> admin, 1 -> member

}
