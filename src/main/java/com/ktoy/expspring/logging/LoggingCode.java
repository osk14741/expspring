package com.ktoy.expspring.logging;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LoggingCode {
    ACCESS_DENIED("0", "접근이 거부되었습니다."),
    LOGOUT("3", "로그아웃 하였습니다."),
    MEMBER_UPDATE("4", "멤버가 업데이트 됐습니다.");

    private String errorCode;
    private String errorText;

}
