package com.ktoy.expspring.logging;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class LoggingService {

    private final LoggingDAO loggingDAO;

    public void insertLogging(LoggingDTO loggingDTO) {
        loggingDAO.insertLogging(loggingDTO);
    }

    public List<LoggingDTO> selectAll(){
        return loggingDAO.selectAll();
    }

}
