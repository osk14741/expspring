package com.ktoy.expspring.logging;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@AllArgsConstructor
public class LoggingDAO {

    private final LoggingMapper loggingMapper;

    public void insertLogging(LoggingDTO loggingDTO){
        loggingMapper.insertLog(loggingDTO);
    }

    public List<LoggingDTO> selectAll() {
        return loggingMapper.selectAll();
    }

}
