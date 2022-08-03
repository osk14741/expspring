package com.ktoy.expspring.logging;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoggingMapper {

    @Insert("Insert into logging_table (loggingType, loggingText) values (#{loggingType}, #{loggingText})")
    void insertLog(LoggingDTO loggingDTO);

    @Select("Select * from logging_table")
    List<LoggingDTO> selectAll();
}
