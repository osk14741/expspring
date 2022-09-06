package com.ktoy.expspring.board;

import lombok.Data;

import java.util.Date;

@Data
public class BoardDTO {
    private int boardIdx;
    private String title;
    private String content;
    private Date regDate;
}
