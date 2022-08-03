package com.ktoy.expspring.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
public enum SecurityErrorCode {
    BAD_CREDENTIALS("1");

    private String value;

}
