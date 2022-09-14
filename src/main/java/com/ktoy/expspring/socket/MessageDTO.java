package com.ktoy.expspring.socket;

import lombok.Data;

import java.util.Date;

@Data
public class MessageDTO {
    private int chatIndex;
    private int memberIdx;
    private String message;
    private Date regDate;
}
