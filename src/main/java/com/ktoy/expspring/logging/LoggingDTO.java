package com.ktoy.expspring.logging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoggingDTO {

    private String loggingType;
    private String loggingText;
}
