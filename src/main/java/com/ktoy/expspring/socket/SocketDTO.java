package com.ktoy.expspring.socket;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SocketDTO {
    private int chatIdx;
    private String title;
    private String description;
    private Date regDate;

    List<MessageDTO> messageList;

}
