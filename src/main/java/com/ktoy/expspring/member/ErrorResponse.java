package com.ktoy.expspring.member;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponse {
    private String statusCode;
    private String errorContent;
    private List<String> messages;

    public ErrorResponse(String statusCode, String errorContent, String messages) {
        this.statusCode = statusCode;
        this.errorContent = errorContent;
        this.messages = new ArrayList<>();
        this.messages.add(messages);
    }

    public ErrorResponse(String statusCode, String errorContent, List<String> messages) {
        this.statusCode = statusCode;
        this.errorContent = errorContent;
        this.messages = messages;
    }
}
