package com.ktoy.expspring.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("ROLE_ADMIN", 0),
    MEMBER("ROLE_MEMBER", 1),
    TEST("ROLE_TEST", 2);

    private String value;
    private int roleCode;

    public String getKey() {
        return name();
    }


}
